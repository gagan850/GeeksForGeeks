package com.management.student.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.management.student.constant.Constant;
import com.management.student.constant.FormParams;
import com.management.student.constant.MessageEnum;
import com.management.student.constant.RequestURL;
import com.management.student.constant.ViewName;
import com.management.student.form.StudentForm;
import com.management.student.model.Student;
import com.management.student.model.StudentList;
import com.management.student.util.MessageUtil;
import com.management.student.validator.StudentAddValidator;
import com.management.student.validator.StudentModifyValidator;

/**
 * The Class StudentService.
 */
@Controller
public class StudentController {

    /** The Constant ACTION. */
    public static final String ACTION = "action";

    /** The Constant UPDATE. */
    public static final String UPDATE = "update";

    /** The Constant STUDENTS_LIST. */
    public static final String STUDENTS_LIST = "studentList";

    /** The Constant STUDENT. */
    public static final String STUDENT = "student";
    
    /** The student add validator. */
    @Autowired
    private StudentAddValidator studentAddValidator;
    
    /** The student modify validator. */
    @Autowired
    private StudentModifyValidator studentModifyValidator;
    
    private final RestTemplate restTemplate = new RestTemplate();
    
    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(StudentController.class);

    @PostConstruct
    public void init() {
        
    }
    
    /**
     * Display login.
     *
     * @return the model and view
     */
    @RequestMapping(value = RequestURL.LOGIN, method = RequestMethod.GET) 
    public ModelAndView displayLogin() {
        ModelAndView outParam = new ModelAndView(ViewName.LOGIN); 
        return outParam; 
    }
    
    
    /**
     * Gets the all.
     * 
     * @param formParams
     *            the form params
     * @return the all
     * @throws IOException
     */
   @RequestMapping(value = RequestURL.STUDENTS_LIST, method = RequestMethod.GET)
    public ModelAndView getAll(final HttpServletRequest request)
        throws IOException {        

        ModelAndView outParam = null;
        List<Student> studentList = getStudentList();
        StudentForm studentForm = new StudentForm();
        studentForm.setStudentList(studentList);
        studentForm.setStatus(Constant.SUCCESS);
        studentForm.setMessage(MessageUtil.getMessage(MessageEnum.VALID_CRIDENTIAL.getValue(), request
            .getParameter("locale")));
        outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        outParam.addObject("StudentForm", studentForm);

        return outParam;
    }

    /**
     * Gets the all.
     * 
     * @param rollNo
     *            the roll no
     * @param formParams
     *            the form params
     * @param request
     *            the request
     * @return the all
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = RequestURL.SAVE_STUDENT, method = RequestMethod.GET)
    public ModelAndView save(@PathVariable(FormParams.ROLL_NO) final String rollNo,
        @Valid @ModelAttribute("StudentForm") final StudentForm studentForm, final BindingResult result,
        final HttpServletRequest request) throws IOException {
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        studentForm.setUserName((String)session.getValue(FormParams.LOGIN_ID));
        studentForm.getModifyStudent().setRollNumber(rollNo);
        studentModifyValidator.validate(studentForm, result);
        if (!result.hasErrors()) {
            
            restTemplate.put("http://localhost:8081/StudentManagement3/students/update", studentForm.getModifyStudent());
            List<Student> studentList = getStudentList();
            studentForm.setStudentList(studentList);
            studentForm.setStatus(Constant.SUCCESS);
            studentForm.setMessage(MessageUtil.getMessage(MessageEnum.STUDENT_UPDATE_SUCCESS.getValue(), request
                .getParameter("locale"), rollNo));
            outParam.addObject("StudentForm", studentForm);
            
        } else {

            List<Student> studentList = getStudentList();
            studentForm.setStudentList(studentList);
            studentForm.setStatus(Constant.ERROR);                        
            studentForm.setModifyStudent(new Student(rollNo));
            studentForm.setAction(UPDATE);
            outParam.addObject("StudentForm", studentForm);

            
        }
        return outParam;
    }

    
    @RequestMapping(value = RequestURL.LOG_OUT, method = RequestMethod.GET)
    public ModelAndView logOut(final HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView(ViewName.LOGIN);
    }
    
    
    @RequestMapping(value="/fail2login", method = RequestMethod.GET)  
    public ModelAndView loginerror() {  
     final ModelAndView model = new ModelAndView(ViewName.LOGIN);
     model.addObject("error", "true");  
     return model;  
      
    }  
    
    /**
     * Removes the student.
     * 
     * @param rollNo
     *            the roll no
     * @return the viewable
     * @throws IOException
     */    
    @RequestMapping(value = RequestURL.REMOVE_STUDENT, method = RequestMethod.GET)
    public ModelAndView removeStudent(@PathVariable(FormParams.ROLL_NO) final String rollNo,
        final HttpServletRequest request) throws IOException {
        restTemplate.delete("http://localhost:8081/StudentManagement3/students/remove/{rollNumber}", new Object[]{rollNo}); 
        List<Student> studentList = getStudentList();
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        StudentForm studentForm = new StudentForm();
        studentForm.setStudentList(studentList);
        studentForm.setUserName((String)session.getValue(FormParams.LOGIN_ID));
        studentForm.setStatus(Constant.SUCCESS);
        studentForm.setMessage(MessageUtil.getMessage(MessageEnum.STUDENT_DELETE_SUCCESS.getValue(), request
            .getParameter("locale"), rollNo));
        outParam.addObject("StudentForm", studentForm);
        return outParam;
    }

    /**
     * Removes the student.
     * 
     * @param rollNo
     *            the roll no
     * @return the viewable
     * @throws IOException
     */
    @RequestMapping(value = RequestURL.ADD_STUDENT, method = RequestMethod.GET)
    public ModelAndView add(@ModelAttribute("StudentForm") final StudentForm studentForm ,final BindingResult result,
        final HttpServletRequest request) throws IOException {
        
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        studentForm.setUserName((String) session.getValue(FormParams.LOGIN_ID));

        studentAddValidator.validate(studentForm, result);
        if (!result.hasErrors()) {

            // Send the request as GET
            String studentAlreadyExist = restTemplate.postForObject(
                "http://localhost:8081/StudentManagement3/students/add", studentForm.getAddStudent(), String.class);
            if (!new Boolean(studentAlreadyExist)) {

                List<Student> studentList = getStudentList();
                studentForm.setStudentList(studentList);
                studentForm.setStatus(Constant.SUCCESS);
                studentForm.setMessage(MessageUtil.getMessage(MessageEnum.STUDENT_ADD_SUCCESS.getValue(), request
                    .getParameter("locale"), studentForm.getAddStudent().getRollNumber()));
                outParam.addObject("StudentForm", studentForm);
            } else {
                List<Student> studentList = getStudentList();
                studentForm.setStudentList(studentList);
                studentForm.setStatus(Constant.ERROR);
                studentForm.setMessage(MessageUtil.getMessage(MessageEnum.STUDENT_ALREADY_EXIST.getValue(), request
                    .getParameter("locale"), studentForm.getAddStudent().getRollNumber()));
                outParam.addObject("StudentForm", studentForm);
            }
        } else {

            List<Student> studentList = getStudentList();            
            studentForm.setStudentList(studentList);
            studentForm.setStatus(Constant.ERROR);
            outParam.addObject("StudentForm", studentForm);
        }
        return outParam;
    }


    /**
     * This API hit the rest service to returns the students list.
     *
     * @return the student list
     */
    private List<Student> getStudentList() {
        StudentList studentList = restTemplate.getForObject("http://localhost:8081/StudentManagement3/students/list",
            StudentList.class);
        List<Student> students = studentList.getStudents();
        return students;
    }

    /**
     * Update.
     * 
     * @param rollNo
     *            the roll no
     * @return the viewable
     * @throws IOException
     */
    @RequestMapping(value = RequestURL.UPDATE_STUDENT, method = RequestMethod.GET)
    public ModelAndView update(@PathVariable(FormParams.ROLL_NO) final String rollNo, 
        @ModelAttribute("StudentForm") final StudentForm studentForm, final HttpServletRequest request)
        throws IOException {

        List<Student> studentList = getStudentList();
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        studentForm.setUserName((String)session.getValue(FormParams.LOGIN_ID));
        studentForm.setStudentList(studentList);
        studentForm.setModifyStudent(new Student(rollNo));
        studentForm.setAction(UPDATE);
        outParam.addObject("StudentForm", studentForm);
        return outParam;

    }

}