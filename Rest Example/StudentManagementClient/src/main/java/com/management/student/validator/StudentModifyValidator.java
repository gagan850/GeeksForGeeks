package com.management.student.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.management.student.form.StudentForm;
import com.management.student.model.Student;

@Component
public class StudentModifyValidator implements Validator {
    public boolean supports(final Class clazz) {
        return StudentForm.class.isAssignableFrom(clazz);
    }

    public void validate(final Object target, final Errors errors) {
        StudentForm studentForm = (StudentForm)target;
        Student modifyStudent = studentForm.getModifyStudent();
        if (StringUtils.isEmpty(modifyStudent.getName())) {
            errors.rejectValue("modifyStudent.name", "Name should not be empty", "Name should not be empty");
        }
        if (modifyStudent.getAge() < 16 || modifyStudent.getAge() > 70) {
            errors.rejectValue("modifyStudent.age", "Age should be between 16 and 70", "Age should be between 16 and 70");
        }
    }
}