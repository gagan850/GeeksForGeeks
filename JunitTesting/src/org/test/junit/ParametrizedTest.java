package org.test.junit;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParametrizedTest {

    
    private static Calculator calculator = new Calculator();
    private final int inputs;
    private final int expected;
    
    
    
    
    
    /**
     * @param inputs
     * @param expected
     */
    public ParametrizedTest(final int inputs, final int expected) {
        super();
        this.inputs = inputs;
        this.expected = expected;
    }
    
    
    
    @Parameters
    public static List<Object[]> data() {
        
        Object[][] object = new Object[][]{{5,5,10},{10,10,20}};
        return Arrays.asList(object);
    }
    
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

