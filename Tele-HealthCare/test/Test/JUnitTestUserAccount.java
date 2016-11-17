package Test;

import Business.UserAccount.UserAccount;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.UserAccountDao;

/**
 *
 * @author Pellisoli Beretta
 */
public class JUnitTestUserAccount {
    
    @Test
    public void userNameValidTest() {
        UserAccount ua = new UserAccount();
        ua.setUsername("bruno");
        String actual = ua.getUsername();
        String expected = "bruno";
        assertEquals(expected, actual);
    }
    
    @Test
    public void userNameInvalidTest() {
        UserAccount ua = new UserAccount();
        ua.setUsername("brunoo");
        String actual = ua.getUsername();
        String expected = "bruno";
        assertEquals(expected, actual);
    }
    
    @Test
    public void PasswordValidTest() {
        UserAccount ua = new UserAccount();
        ua.setPassword("12345");
        String actual = ua.getPassword();
        String expected = "12345";
        assertEquals(expected, actual);
    }
    
    @Test
    public void PasswordInvalidTest() {
        UserAccount ua = new UserAccount();
        ua.setPassword("123456");
        String actual = ua.getPassword();
        String expected = "12345";
        assertEquals(expected, actual);
    }
    
}
