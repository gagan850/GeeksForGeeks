package org.test.junit;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTests {
    
    @BeforeClass
    public static void beforeClass() {
       System.out.print("Before Class");        
    }
    
    @AfterClass
    public static void afterClass() {
       System.out.print("After Class");        
    }
    
    @Before
    public void befor3() {
       System.out.print("Before");        
    }
    
    
    @After
    public void after() {
       System.out.print("After");        
    }
    
    @Test(expected=Exception.class)
    public void add() {
       Calculator cal = new Calculator();
       int result = cal.add(-3, 5);
       assertEquals("Correct", 15, result);        
    }
    
    @Test
    @Ignore
    public void sub() {
       Calculator cal = new Calculator();
       int result = cal.sub(10, 5);
       assertEquals("Correct", 5, result);        
    }
    
    @Test
    @Ignore
    public void mul() {
       Calculator cal = new Calculator();
       int result = cal.mul(10, 5);
       assertEquals("Correct", 50, result);        
    }

}
