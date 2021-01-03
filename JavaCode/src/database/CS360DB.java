package database;

import java.sql.*;

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
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                url + ":" + port + "/" + databaseName + "?characterEncoding=UTF-8", username, password);
    }


}
