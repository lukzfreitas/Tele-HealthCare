/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;
import persistence.UserAccountDao;

/**
 *
 * @author Neelu
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    private ArrayList<UserAccount> userAccountListDB;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        UserAccountDao userAccountDao = new UserAccountDao();
        userAccountListDB = userAccountDao.findAll();
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){        
        UserAccount userAccount = new UserAccount();
        UserAccountDao userAccountDao = new UserAccountDao();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountDao.insert(userAccount);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){                
        for (UserAccount ua : userAccountList){            
            if (ua.getUsername().equals(username))
                return true;
        }
        return false;
    }
}
