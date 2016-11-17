package Test;

import Business.Employee.EmployeeDirectory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pellisoli
 */
public class JUnitTestEmployeeDirectory {
    
    @Test
    public void testCreateEmployee() throws Exception {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.createEmployee("Bruno");
        String actual = "Bruno";
        String expected = employeeDirectory.getEmployeeList().get(0).getName();        
        assertEquals(expected, actual);
    }
}
