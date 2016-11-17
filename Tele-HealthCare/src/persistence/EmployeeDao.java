/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import Business.Employee.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Lucas
 */
public class EmployeeDao {

        
    public void insert(Employee employee) {                          
        String sql = "INSERT INTO employees("                                
                + "name,"
                + "primarydoctor,"
                + "patientcount,"
                + "email,"
                + "skypeid,"
                + "age) values(?,?,?,?,?,?)";
        int result = 0;
        try (Connection connection = InitializeDataSource.connectDataBase()) {                                    
            try (PreparedStatement command = connection.prepareStatement(sql)) {                
                command.setString(1, employee.getName());
                command.setString(2, employee.getPrimaryDoctor());
                command.setInt(3, employee.getPatientCount());
                command.setString(4, employee.getEmail());
                command.setString(5, employee.getSkypeId());
                command.setInt(6, employee.getAge());
                result = command.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("insertion failure employee", e);
        }
        if (result == 0) {
            throw new IllegalArgumentException("insertion failure");
        }
    }
    
    public Employee findBy(int id) {
        String sql = "select * from employees where id = ?";
        Employee employee = null;
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {
                command.setInt(1, id);
                try (ResultSet result = command.executeQuery()) {
                    if (result.next()) {         
                        employee = new Employee(id);
                        employee.setName(result.getString("name"));
                        employee.setPrimaryDoctor(result.getString("primarydoctor"));        
                        employee.setPatientCount(result.getInt("patientcount"));
                        employee.setEmail(result.getString("email"));
                        employee.setSkypeId(result.getString("skypeid"));
                        employee.setAge(result.getInt("age"));
                    }
                    return employee;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("search failure", e);
        }
    }
    
    public ArrayList<Employee> findAll() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        String sql = "select * from employees";
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (Statement command = connection.createStatement()) {
                try (ResultSet result = command.executeQuery(sql)) {
                    while (result.next()) {
                        Employee employee = new Employee(result.getInt("id"));                                                                                
                        employee.setName(result.getString("name"));
                        employee.setPrimaryDoctor(result.getString("primarydoctor"));
                        employee.setPatientCount(result.getInt("patientcount"));
                        employee.setEmail(result.getString("email"));
                        employee.setSkypeId(result.getString("skypeid"));
                        employee.setAge(result.getInt("age"));
                        list.add(employee);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("connection failure", e);
        }
    }    
}
