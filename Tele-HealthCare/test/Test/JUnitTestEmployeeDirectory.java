package Test;

import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.EmployeeDao;

/**
 *
 * @author Pellisoli
 */
public class JUnitTestEmployeeDirectory {
    
    // Testes da camada de persistencia

    @Test
     public void testFindAllEmployees() throws Exception {
         EmployeeDirectory employeeDirectory = new EmployeeDirectory();
         employeeDirectory.createEmployee("Maradona");
         EmployeeDao employee = new EmployeeDao();
         ArrayList<Employee> list =  employee.findAll();
         String actual = list.get(list.size() - 1).getName();
         String excepted = "Maradona";
         assertEquals(actual, excepted);         
     }
}
