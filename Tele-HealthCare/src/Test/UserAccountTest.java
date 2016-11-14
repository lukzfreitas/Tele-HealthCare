package Test;

import Business.UserAccount.UserAccount;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author TEAM
 * 
 * WORKING IN PROGRESS
 */
public class UserAccountTest {
    
    @Test
    public void testUserName() {
        UserAccount ua = new UserAccount();
        String actual = ua.getUsername();
        String expected = "bruno";
        assertEquals(expected, actual);
    }
    
}
