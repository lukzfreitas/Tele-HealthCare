/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Lucas
 */
public class PatientOrganizationDao {
    
    public void insert(Organization patientOrganization) {        
        String sql = "INSERT INTO patientorganization("
                + "organizationid,"
                + "name) values(?,?)";
        int result = 0;
        System.out.println(sql);
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {                
                command.setInt(1, patientOrganization.getOrganizationID());
                command.setString(2, patientOrganization.getName());                
                result = command.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("insertion failure organization", e);
        }
        if (result == 0) {
            throw new IllegalArgumentException("insertion failure");
        }
    }
    
    public ArrayList<Organization> findAll() {
        ArrayList<Organization> list = new ArrayList<Organization>();
        String sql = "select * from organization";
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (Statement command = connection.createStatement()) {
                try (ResultSet result = command.executeQuery(sql)) {
                    while (result.next()) {
                        Organization patientOrganization = new PatientOrganization();                        
                        patientOrganization.setName(result.getString("name"));                        
                        list.add(patientOrganization);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("connection failure", e);
        }
    }
}
