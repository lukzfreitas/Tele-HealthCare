package Test;

import Business.Employee.Employee;
import Business.Role.AdminRole;
import Business.Role.PatientRole;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pellisoli Beretta
 */
public class JUnitTestUserAccountDirectory {
    
    @Test
    public void testCreateUserAccountValid() {
        UserAccountDirectory userAccountDirectory = new UserAccountDirectory();
        Employee employee = new Employee();                
        userAccountDirectory.createUserAccount("Bruno", "123456", employee, new AdminRole());
        
        boolean actual = userAccountDirectory.checkIfUsernameIsUnique("Bruno");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    
     @Test
    public void testCreateUserAccountInvalid() {
        UserAccountDirectory userAccountDirectory = new UserAccountDirectory();
        Employee employee = new Employee();                
        userAccountDirectory.createUserAccount("Bruno", "123456", employee, new AdminRole());
        
        boolean actual = userAccountDirectory.checkIfUsernameIsUnique("Pelé");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAuthenticateUserValidUsername() {
        UserAccountDirectory userAccountDirectory = new UserAccountDirectory();
        Employee employee = new Employee();
        UserAccount actual = userAccountDirectory.createUserAccount("Sabrina", "123456", employee, new PatientRole());
        UserAccount expected = userAccountDirectory.authenticateUser("Sabrina", "123456");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAuthenticateUserInvalidUsername() {
        UserAccountDirectory userAccountDirectory = new UserAccountDirectory();                
        UserAccount actual = null;
        UserAccount expected = userAccountDirectory.authenticateUser("Peleeee", "123456");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAuthenticateUserInvalidPassword() {
        UserAccountDirectory userAccountDirectory = new UserAccountDirectory();                
        UserAccount actual = null;
        UserAccount expected = userAccountDirectory.authenticateUser("Sabrina", "654321");
        assertEquals(expected, actual);
    } 
}
