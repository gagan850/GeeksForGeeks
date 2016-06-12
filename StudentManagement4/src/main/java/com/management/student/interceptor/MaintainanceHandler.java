package com.management.student.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class MaintainanceHandler extends HandlerInterceptorAdapter  {

    Logger logger = Logger.getLogger(ExecutionTimeHandler.class);
    
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        Calendar startTime = Calendar.getInstance();
        int hour = startTime.get(Calendar.HOUR_OF_DAY);
        if (hour ==8) {
            response.sendRedirect("maintainance");
            return false;
        }
        return true;

        
    }

}
