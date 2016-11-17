/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.PatientRole;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class UserAccountDao {   
    
    
    public void insert(UserAccount userAccount) {                
        
        String sql = "INSERT INTO useraccount("                
                + "username,"
                + "password,"
                + "employeeid) values(?,?,?)";                
        int result = 0;        
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {                
                command.setString(1, userAccount.getUsername());
                command.setString(2, userAccount.getPassword());                
                command.setInt(3, userAccount.getEmployee().getId());                
                result = command.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("insertion failure user account", e);
        }
        if (result == 0) {
            throw new IllegalArgumentException("insertion failure");
        }
    }
    
    public UserAccount findBy(int id) {
        String sql = "select * from useraccount where id = ?";
        EmployeeDao employeeDao = new EmployeeDao();
        UserAccount userAccount = null;
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {
                command.setInt(1, id);
                try (ResultSet result = command.executeQuery()) {
                    if (result.next()) {                              
                            
                        userAccount = new UserAccount(id);
                        userAccount.setUsername(result.getString("username"));                        
                        userAccount.setPassword(result.getString("password"));
                        Employee employee = employeeDao.findBy(result.getInt("employeeid"));
                        userAccount.setEmployee(employee);
                    }
                    return userAccount;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("search failure", e);
        }
    }
    
    public ArrayList<UserAccount> findAll() {        
        ArrayList<UserAccount> list = new ArrayList<>();
        EmployeeDao employeeDao = new EmployeeDao();        
        String sql = "select * from useraccount";        
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (Statement command = connection.createStatement()) {
                try (ResultSet result = command.executeQuery(sql)) {
                    while (result.next()) {                                               
                        UserAccount userAccount = new UserAccount(result.getInt("id"));                        
                        userAccount.setRole(new PatientRole());
                        userAccount.setUsername(result.getString("username"));                        
                        userAccount.setPassword(result.getString("password"));
                        Employee employee = employeeDao.findBy(result.getInt("employeeid"));
                        userAccount.setEmployee(employee);
                        list.add(userAccount);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("connection failure", e);
        }
    }    
}
