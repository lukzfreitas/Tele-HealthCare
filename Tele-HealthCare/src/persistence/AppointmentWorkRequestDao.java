/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import Business.UserAccount.UserAccount;
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
    
    public void insert(AppointmentWorkRequest appointment) {       
        String sql = "insert into appointmentworkrequest("                 
                + "message,"
                + "status,"
                + "result,"
                + "doctorname,"
//                + "requestdate,"
//                + "resolvedate,"
                + "useraccountsenderid,"
                + "usersaccountreceiverid)"
                + " values(?,?,?,?,?,?)";
        int result = 0;
        try (Connection connection = InitializeDataSource.connectDataBase()) {
            try (PreparedStatement command = connection.prepareStatement(sql)) {
                command.setString(1, appointment.getMessage());
                command.setString(2, appointment.getMessage());
                command.setString(3, appointment.getResult());
                command.setString(4, appointment.getDoctorName());
//                command.setString(5, appointment.getRequestDate().toString());
//                command.setString(6, appointment.getResolveDate().toString());
                command.setInt(5, appointment.getSender().getId());
                command.setInt(6, appointment.getReceiver().getId());                
                result = command.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("insertion failure", e);
        }
        if (result == 0) {
            throw new IllegalArgumentException("insertion failure");
        }
    }
    
    public List<AppointmentWorkRequest> findAll() {
        UserAccountDao userAccountDao = new UserAccountDao();
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
                        UserAccount userSender = userAccountDao.findBy(result.getInt("useraccountsenderid"));
                        UserAccount userReceiver = userAccountDao.findBy(result.getInt("useraccountreceiverid"));
                        appointment.setSender(userSender);
                        appointment.setReceiver(userReceiver);
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
}
