/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author loukas
 */
public class CS360DB {

    private static final String url = new String("jdbc:mysql://localhost");
    private static final String databaseName = new String("HospitalEmergencyDepartment");
    private static final int port = 3306;
    private static final String username = new String("root");
    private static final String password = new String("");

    /**
     *
     * @return connection to the database
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("connection is on");
        return DriverManager.getConnection(
                url + ":" + port + "/" + databaseName + "?zeroDateTimeBehavior=CONVERT_TO_NULL", username, password);
    }

}
