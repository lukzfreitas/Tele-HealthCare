package Test;

import Business.UserAccount.UserAccount;
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
public class JUnitTestUserAccount {
    
    @Test
    public void NovoEmptyJUnitTest() {
        UserAccount ua = new UserAccount();
        ua.setUsername("bruno");
        String actual = ua.getUsername();
        String expected = "bruno";
        assertEquals(expected, actual);
    }
    
    
}