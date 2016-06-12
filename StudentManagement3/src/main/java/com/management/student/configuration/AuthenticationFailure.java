package com.management.student.configuration;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


/**
 * The Class AuthenticationFailure, wrapper over the authentication failure handler.
 */
public class AuthenticationFailure implements AuthenticationFailureHandler {

    public void
        onAuthenticationFailure(final HttpServletRequest arg0, final HttpServletResponse response, final AuthenticationException arg2)
            throws IOException, ServletException {
            response.sendError(500);        
    }

}
