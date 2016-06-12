package com.management.student.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionAdvice {
 
    @ExceptionHandler(Exception.class)
    public String exception(final Exception e) {
 
        return "error";
    }
}
