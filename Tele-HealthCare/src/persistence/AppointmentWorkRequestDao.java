/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import Business.WorkQueue.AppointmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class AppointmentWorkRequestDao {
    
    private int count = 1;
    
    public List<AppointmentWorkRequest> findAll() {
        List<AppointmentWorkRequest> list = new ArrayList<AppointmentWorkRequest>();
        String sql = "select * from appointmentworkrequest";
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (Statement command = connection.createStatement()) {
                try (ResultSet result = command.executeQuery(sql)) {
                    while (result.next()) {
                        AppointmentWorkRequest appointment = new AppointmentWorkRequest();
                        appointment.setMessage(result.getString("message"));
                        appointment.setStatus(result.getString("status"));        
                        appointment.setResult(result.getString("result"));
                        appointment.setDoctorName(result.getString("doctorname"));
                        list.add(appointment);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("connection failure", e);
        }
    }
    
    public AppointmentWorkRequest findById(int id) {
        String sql = "select * from appointmentworkrequest where id = ?";
        AppointmentWorkRequest appointment = null;
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {
                command.setInt(1, id);
                try (ResultSet result = command.executeQuery()) {
                    if (result.next()) {         
                        appointment = new AppointmentWorkRequest();
                        appointment.setMessage(result.getString("message"));
                        appointment.setStatus(result.getString("status"));        
                        appointment.setResult(result.getString("result"));
                        appointment.setDoctorName(result.getString("doctorname"));
                    }
                    return appointment;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("search failure", e);
        }
    }    
    
    public void insert(AppointmentWorkRequest appointment) {
        String sql = "insert into appointmentworkrequest(" 
                + "id,"
                + "message,"
                + "status,"
                + "result,"
                + "doctorname,"
                + "requestdate,"
                + "resolvedate,"
                + "fk_usersccountsender,"
                + " fk_usersaccountreceiver)"
                + " values(?,?,?,?,?,?,?,?,?)";
        int result = 0;
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {
                command.setInt(1, count); count++;
                command.setString(2, appointment.getMessage());
                result = command.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("insertion failure", e);
        }
        if (result == 0) {
            throw new IllegalArgumentException("insertion failure");
        }
    }
}
