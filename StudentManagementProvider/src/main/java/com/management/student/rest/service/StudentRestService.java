package com.management.student.rest.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.management.student.constant.RequestURL;
import com.management.student.model.Student;
import com.management.student.model.StudentList;
import com.management.student.service.IStudentService;

/**
 * The Class StudentRestService, it performs the crud operations on students record and
 *  returns the corresponding results to requested rest url.
 */
@Controller
public class StudentRestService {

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

    
    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(StudentRestService.class);

    
    /**
     * This service Returns all the students list.
     *
     * @return the students list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = RequestURL.STUDENTS_LIST, method = RequestMethod.GET,
        headers="Accept=application/xml")
    @ResponseBody
    public StudentList getAll() throws IOException {
        List<Student> students = this.studentService.getAll();
        StudentList studentList = new StudentList();
        studentList.setStudents(students);
        return studentList;
    }
    

    /**
     * This service adds the requested student into the database.
     *
     * @param student, the student to add in database
     * @return boolean, true if students already exist, false if added successfully
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = RequestURL.ADD_STUDENT, method = RequestMethod.POST, 
        headers="Accept=application/xml" , produces="text/plain")
    @ResponseBody
    public String add(@RequestBody final Student student) throws IOException {

        boolean alreadyExist = true;
        if (!this.studentService.alreadyExist(student.getRollNumber())) {
            this.studentService.add(student);
            alreadyExist = false;

        }
        return String.valueOf(alreadyExist);
    }

    /**
     * This Service updates the requested students information.
     *
     * @param student, the students to modify the info
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = RequestURL.UPDATE_STUDENT, method = RequestMethod.PUT, 
        headers="Accept=application/xml")
    @ResponseBody
    public void update(@RequestBody final Student student)
        throws IOException {
        this.studentService.update(student);
    }

    /**
     * This service removes the requested student from the database.
     *
     * @param rollNumber, the roll number to remove from the db
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = RequestURL.REMOVE_STUDENT, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable final String rollNumber)
        throws IOException {
        this.studentService.removeStudent(rollNumber);
    }

}