package org.test.junit;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return "hello";
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
