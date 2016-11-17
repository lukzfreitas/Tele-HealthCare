/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;

/**
 *
 * @author Lucas
 */
public class InitializeDataSource {
    
    public static String DB_NAME = "DBTeleHealthCare";
    public static String USER_NAME = "root";
    public static String PASSWORD = "password";
    private static DataSource dataSource;
    
    
    private static DataSource createDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }
    
    public static void createDatabase() throws Exception {
        try (Connection con = createDataSource().getConnection();
                Statement sta = con.createStatement()) {
//            String sqlOrganization = "CREATE TABLE patientorganization("
//                    + "organizationid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
//                    + "name varchar(100))";                    
//            sta.executeUpdate(sqlOrganization);
            String sqlEmployee = "CREATE TABLE employees("
                    + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"                    
                    + "name varchar(100),"
                    + "primarydoctor varchar(100),"
                    + "patientcount int,"
                    + "email varchar(100),"
                    + "skypeid varchar(100),"
                    + "age int)";
            sta.executeUpdate(sqlEmployee);
            String sqlUserAccount = "CREATE TABLE useraccount("
                    + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "username varchar(100) NOT NULL,"
                    + "password varchar(100) NOT NULL,"
                    + "employeeid int NOT NULL)";
            sta.executeUpdate(sqlUserAccount);            
            String sqlAppointment = "CREATE TABLE appointmentworkrequest("
                    + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "message varchar(100) NOT NULL,"
                    + "status varchar(100) NOT NULL,"
                    + "result varchar(100) NOT NULL,"
                    + "doctorname varchar(100) NOT NULL,"
//                    + "requestdate varchar(20) NOT NULL," 
//                    + "resolvedate varchar(100) NOT NULL"
                    + "useraccountsenderid int NOT NULL,"
                    + "usersaccountreceiverid int NOT NULL)"; 
            sta.executeUpdate(sqlAppointment);
        }
    }
    
    public static Connection connectDataBase() throws Exception {
        return createDataSource().getConnection();
    }
}
    