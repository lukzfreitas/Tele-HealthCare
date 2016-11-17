/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.EmployeeDao;

/**
 *
 * @author Lucas
 */
public class EmployeesTest {
    
    public EmployeesTest() {
    }

    // TODO add test methods here.
    // Testes da camada de persistencia
    //
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
