package com.management.student.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.management.student.form.StudentForm;
import com.management.student.model.Student;

@Component
public class StudentAddValidator implements Validator {
    public boolean supports(final Class clazz) {
        return StudentForm.class.isAssignableFrom(clazz);
    }

    public void validate(final Object target, final Errors errors) {
        StudentForm studentForm = (StudentForm)target;
        Student addStudent = studentForm.getAddStudent();
        if (StringUtils.isEmpty(addStudent.getName())) {
            errors.rejectValue("addStudent.name", "Name should not be empty", "Name should not be empty");
        }
        if (StringUtils.isEmpty(addStudent.getRollNumber())) {
            errors.rejectValue("addStudent.rollNumber", "Roll Number should not be empty", "Roll Number should not be empty");
        }
        if (addStudent.getAge() < 16 || addStudent.getAge() > 70) {
            errors.rejectValue("addStudent.age", "Age should be between 16 and 70", "Age should be between 16 and 70");
        }
    }
}