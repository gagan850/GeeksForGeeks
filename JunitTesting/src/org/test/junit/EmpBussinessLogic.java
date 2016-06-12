package org.test.junit;



public class EmpBussinessLogic {

    public double calculateYearlySalary(final EmployeeDetails empDetail) {
        double yearlySalary = 0;
        yearlySalary = empDetail.getMonthlySalary()*12;
        return yearlySalary;        
    }
    
    
    public double calculateAppraisal(final EmployeeDetails empDetail) {
        
        double appraisal = 0;
        if (empDetail.getMonthlySalary() < 10000) {
            appraisal = 500;
        } else {
            appraisal = 1000;
        }
    
    return appraisal;
    }
}
