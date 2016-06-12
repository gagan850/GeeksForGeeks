package com.management.student.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * The Class LoggingAspect, is used to log the entry and exit of each method.
 */
@Aspect
@Component
public class LoggingAspect {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(LoggingAspect.class);
    
    
    /**
     * All methods, this pointcut defines all the public method.
     */
    @Pointcut("execution(public * *(..))") 
    public void allMethods() {}
    
    /**
     * Before calling method, before the actual implementation of the method, 
     * this aspect should print that this method execution has been start.
     *
     * @param joinPoint the join point
     */
    @Before("allMethods()")
    public void beforeCallingMethod(final JoinPoint joinPoint) {
        logger.debug("Entered in Method " + joinPoint.getSignature().getName());
    }

    /**
     * After calling method, after the actual implementation of the method, 
     * this aspect should print that this method execution has been complete.
     * 
     * @param joinPoint
     *            the join point
     */
    @Before("allMethods()")    
    public void AfterCallingMethod(final JoinPoint joinPoint) {
        logger.debug("Exited from Method " + joinPoint.getSignature().getName());

    }
}
