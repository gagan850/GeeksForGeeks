package org.test.junit;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EmpParamTests {

    static EmpBussinessLogic empLogic = new EmpBussinessLogic();
    /** The monthly salary. */
    private final double monthlySalary;

    /** The expected yearly salary. */
    private final double expectedYearlySalary;

    /** The expected appraisal. */
    private final double expectedAppraisal;

    enum TYPE {YES, NO};
    
    /** The type. */
    private TYPE type;

    /**
     * @param monthlySalary
     * @param expectedYearlySalary
     * @param expectedAppraisal
     */
    public EmpParamTests(TYPE type, final double monthlySalary, final double expectedYearlySalary, final double expectedAppraisal) {
        super();
        this.type = type;
        this.monthlySalary = monthlySalary;
        this.expectedYearlySalary = expectedYearlySalary;
        this.expectedAppraisal = expectedAppraisal;
    }

    @Parameters
    public static List<Object[]> data() {

        Object[][] object = new Object[][] { {TYPE.YES, 20000, 20000 * 12, 1000 }, { TYPE.YES, 2000, 2000 * 12, 500 },
                {TYPE.YES, -20000, -20000 * 12, 500 }, {TYPE.YES, -2000, -2000 * 12, 500 }, {TYPE.YES, 0, 0 * 12, 500 }, 
                {TYPE.YES, 0, 0 * 12, 500 }};
        return Arrays.asList(object);
    }

    @BeforeClass
    public static void before() {
        empLogic = new EmpBussinessLogic();

    }

    @AfterClass
    public static void after() {
        empLogic = null;

    }

//    @Test(expected = RuntimeException.class)
//    public void testCalculateAppraisalIfMonthlySalaryIsNull() {
//        Assume.assumeTrue(type == TYPE.NO);
//        EmployeeDetails empDetail = new EmployeeDetails();
//        empDetail.setMonthlySalary((Double) null);
//        Double result = empLogic.calculateAppraisal(empDetail);
//    }

    @Test
    public void calculateAppraisal_Zero_Salary() {
        //System.out.println("Before" + type);
        Assume.assumeTrue(type == TYPE.NO);
        System.out.println("After" + type);
        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setMonthlySalary(monthlySalary);
        double result = empLogic.calculateAppraisal(empDetail);
        System.out.println(result);
        assertEquals("Correct", expectedAppraisal, result, 0);
    }

    @Test
    public void calculateYearlySalary_Positive_salary() {

        EmployeeDetails empDetail = new EmployeeDetails();
        empDetail.setMonthlySalary(monthlySalary);
        double result = empLogic.calculateYearlySalary(empDetail);
        System.out.println(result);
        assertEquals("Correct", expectedYearlySalary, result, 0);
    }

}
