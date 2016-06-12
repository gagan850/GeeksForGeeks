package org.test.junit;

public class Calculator {

    public int add(final int a , final int b) {
        if (a <0) {
            throw new RuntimeException();
        }
        return a+b;
        
    }
    
    
    public int sub(final int a , final int b) {
        return a - b;
        
    }
    
    public int mul(final int a , final int b) {
        return a*b;
        
    }

    
}