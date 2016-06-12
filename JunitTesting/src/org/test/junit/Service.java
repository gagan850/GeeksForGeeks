package org.test.junit;

public class Service {

    
    
    public static void main(final String...s) {
 
        int a =10;
        int b=20;
        Calculator cal = new Calculator();
        System.out.println(cal.add(3,b));
        System.out.println(cal.sub(a,b));
        System.out.println(cal.mul(a,b));
        
        
        EmployeeDetails empDetal = new EmployeeDetails();
        empDetal.setAge(23);
        empDetal.setMonthlySalary(12000);
        empDetal.setName("Gagan");
        EmpBussinessLogic empLogic = new EmpBussinessLogic();
        System.out.println(empLogic.calculateAppraisal(empDetal));
        System.out.println(empLogic.calculateYearlySalary(empDetal));
    }

}
