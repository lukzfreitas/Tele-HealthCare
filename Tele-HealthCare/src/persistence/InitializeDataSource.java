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
    
    public static String DB_NAME = "TeleHealthCare";
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
            String sqlEmployee = "CREATE TABLE EMPLOYEES("
                    + "ID int(100) PRIMARY KEY NOT NULL,"
                    + "NAME int(100) NOT NULL,"
                    + "PRIMARYDOCTOR varchar(100) NOT NULL,"
                    + "PATIENTCOUNT int(20) NOT NULL,"
                    + "EMAIL varchar(100) PRIMARY KEY NOT NULL,"
                    + "SKYPEID varchar(100) NOT NULL,"
                    + "AGE int(2) NOT NULL)";
            sta.executeUpdate(sqlEmployee);
            String sqlUserAccount = "CREATE TABLE USERSACCOUNT("
                    + "ID int PRIMARY KEY NOT NULL,"
                    + "USERNAME varchar(100) NOT NULL,"
                    + "PASSWORD varchar(100) NOT NULL)";
            sta.executeUpdate(sqlUserAccount);            
            String sqlAppointment = "CREATE TABLE APPOINTMENTWORKREQUEST("
                    + "ID int(100) PRIMARY KEY NOT NULL,"
                    + "MESSAGE varchar(100) NOT NULL,"
                    + "STATUS varchar(100) NOT NULL,"
                    + "RESULT varchar(100) NOT NULL,"
                    + "DOCTORNAME varchar(100) NOT NULL,"
                    + "REQUESTDATE varchar(20) NOT NULL," // trocar para tipo Date
                    + "RESOLVEDATE varchar(100) NOT NULL," // trocar para tipo Date                    
                    + "CONSTRAINT FK_USERSACCOUNTSENDER FOREIGN KEY (IDUSERACCOUNT) REFERENCES USERSACCOUNT(ID),"
                    + "CONSTRAINT FK_USERSACCOUNTRECEIVER FOREIGN KEY (IDUSERACCOUNT) REFERENCES USERSACCOUNT(ID))";
            sta.executeUpdate(sqlEmployee);
        }
    }
    
    public static Connection connectDataBase() throws Exception {
        return createDataSource().getConnection();
    }
}
    