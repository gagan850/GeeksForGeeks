package com.management.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.management.student.constant.Constant;
import com.management.student.constant.FormParams;
import com.management.student.constant.MessageEnum;
import com.management.student.constant.RequestURL;
import com.management.student.constant.ViewName;
import com.management.student.form.StudentForm;
import com.management.student.model.Student;
import com.management.student.model.UserDetail;
import com.management.student.service.IStudentService;
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

    /** The student dao. */
    @Autowired
    private IStudentService studentService;
    
    /** The student add validator. */
    @Autowired
    private StudentAddValidator studentAddValidator;
    
    /** The student modify validator. */
    @Autowired
    private StudentModifyValidator studentModifyValidator;
    
    @Autowired
    private MessageSource messageSource;
    
    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(StudentController.class);

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
                List<Student> studentList = this.studentService.getAll();
                StudentForm studentForm = new StudentForm();
                studentForm.setStudentList(studentList);
                studentForm.setStatus(Constant.SUCCESS);
                studentForm.setMessage(messageSource.getMessage(MessageEnum.VALID_CRIDENTIAL.getValue(), new Object[]{}, LocaleContextHolder.getLocale()));
                SecurityContext secContext = SecurityContextHolder.getContext();
                Authentication auth = secContext.getAuthentication();
                UserDetail user = (UserDetail) auth.getPrincipal();
                studentForm.setUserName(user.getUsername());
                outParam = new ModelAndView(ViewName.STUDENTS_LIST);
                outParam.addObject("StudentForm", studentForm);
                HttpSession session = request.getSession();
                session.setAttribute(FormParams.LOGIN_ID, user.getUsername());
                logger.info(FormParams.LOGIN_ID + " :" + user.getUsername());
            

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
        final HttpServletRequest request, final Locale locale) throws IOException {
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        studentForm.setUserName((String)session.getValue(FormParams.LOGIN_ID));
        studentForm.getModifyStudent().setRollNumber(rollNo);
        studentModifyValidator.validate(studentForm, result);
        
        if (!result.hasErrors()) {
            this.studentService.update(studentForm.getModifyStudent());
            List<Student> studentList = this.studentService.getAll();
            studentForm.setStudentList(studentList);
            studentForm.setStatus(Constant.SUCCESS);
            studentForm.setMessage(messageSource.getMessage(MessageEnum.STUDENT_UPDATE_SUCCESS.getValue(), new Object[]{rollNo}, LocaleContextHolder.getLocale()));
            outParam.addObject("StudentForm", studentForm);
            
        } else {
            List<Student> studentList = this.studentService.getAll();
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
    
    @RequestMapping(value="/maintainance", method = RequestMethod.GET)  
    public ModelAndView maintainance() {  
     final ModelAndView model = new ModelAndView("maintainance");
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
        this.studentService.removeStudent(rollNo);
        List<Student> studentList = this.studentService.getAll();
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        StudentForm studentFrom = new StudentForm();
        studentFrom.setUserName((String)session.getValue(FormParams.LOGIN_ID));
        studentFrom.setStudentList(studentList);
        studentFrom.setStatus(Constant.SUCCESS);
        studentFrom.setMessage(messageSource.getMessage(MessageEnum.STUDENT_DELETE_SUCCESS.getValue(), new Object[]{rollNo}, LocaleContextHolder.getLocale()));
        outParam.addObject("StudentForm", studentFrom);
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
            
            String rollNumber = studentForm.getAddStudent().getRollNumber();
            if (!this.studentService.alreadyExist(rollNumber)) {
                this.studentService.add(studentForm.getAddStudent());
                List<Student> studentList = this.studentService.getAll();
                studentForm.setStudentList(studentList);
                studentForm.setStatus(Constant.SUCCESS);
                
                studentForm.setMessage(messageSource.getMessage(MessageEnum.STUDENT_ADD_SUCCESS.getValue(), new Object[]{studentForm
                    .getAddStudent().getRollNumber()}, LocaleContextHolder.getLocale()));
                outParam.addObject("StudentForm", studentForm);
            } else {
                List<Student> studentList = this.studentService.getAll();
                studentForm.setStudentList(studentList);
                studentForm.setStatus(Constant.ERROR);
                studentForm.setMessage(messageSource.getMessage(MessageEnum.STUDENT_ALREADY_EXIST.getValue(), new Object[]{studentForm.getAddStudent().getRollNumber()}, LocaleContextHolder.getLocale()));
                outParam.addObject("StudentForm", studentForm);
            }
        } else {
            List<Student> studentList = this.studentService.getAll();            
            studentForm.setStudentList(studentList);
            studentForm.setStatus(Constant.ERROR);
            outParam.addObject("StudentForm", studentForm);
        }
        return outParam;
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
        List<Student> studentList = this.studentService.getAll();
        ModelAndView outParam = new ModelAndView(ViewName.STUDENTS_LIST);
        HttpSession session = request.getSession();
        studentForm.setUserName((String)session.getValue(FormParams.LOGIN_ID));
        studentForm.setStudentList(studentList);
        studentForm.setModifyStudent(new Student(rollNo));
        studentForm.setAction(UPDATE);
        outParam.addObject("StudentForm", studentForm);
        return outParam;

    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(final Exception e) {
 ModelAndView errorView = new ModelAndView("error");
 errorView.addObject("exception", e);
        return errorView;
    }

}