package org.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpTestSpring {

    @Autowired
    static EmpBussinessLogic empLogic;

    

    @AfterClass
    public static void after() {
        empLogic = null;
        
    }

    
    @Test
    public void calculateAppraisal_Positive_Salary_GT_Boundary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(20000);
        empDetail.setAge(23);        
        double result = empLogic.calculateAppraisal(empDetail);
        System.out.println(result);
        assertEquals("Correct", 1000, result,0); 
    }

    @Test
    public void calculateAppraisal_Positive_Salary_LT_Boundary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(2000);
        empDetail.setAge(23);        
        double result = empLogic.calculateAppraisal(empDetail);
        System.out.println(result);
        assertEquals("Correct", 500, result,0); 
    }
    
    @Test
    public void calculateAppraisal_Negative_Salary_GT_Boundary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(-20000);
        empDetail.setAge(23);        
        double result = empLogic.calculateAppraisal(empDetail);
        System.out.println(result);
        assertEquals("Correct", 500, result,0); 
    }

    @Test
    public void calculateAppraisal_Negative_Salary_LT_Boundary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(-2000);
        empDetail.setAge(23);        
        double result = empLogic.calculateAppraisal(empDetail);
        System.out.println(result);
        assertEquals("Correct", 500, result,0); 
    }
    
    @Test
    public void calculateAppraisal_Zero_Salary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(0);
        empDetail.setAge(23);        
        double result = empLogic.calculateAppraisal(empDetail);
        System.out.println(result);
        assertEquals("Correct", 500, result,0); 
    }

    @Test
    public void calculateYearlySalary_Positive_salary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(2000);
        empDetail.setAge(23);        
        double result = empLogic.calculateYearlySalary(empDetail);
        System.out.println(result);
        assertEquals("Correct", 2000*12, result,0); 
    }
    
    @Test
    public void calculateYearlySalary_Negative_Salary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(-2000);
        empDetail.setAge(23);        
        double result = empLogic.calculateYearlySalary(empDetail);
        System.out.println(result);
        assertEquals("Correct", -2000*12, result,0); 
    }
    
    @Test
    public void calculateYearlySalary_Zero_Salary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setName("Gagan");
        empDetail.setMonthlySalary(0);
        empDetail.setAge(23);        
        double result = empLogic.calculateYearlySalary(empDetail);
        System.out.println(result);
        assertEquals("Correct", 0*12, result,0); 
    }
}
