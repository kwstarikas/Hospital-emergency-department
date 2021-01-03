
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;


public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = new String("jdbc:mysql://localhost");
            String databaseName = new String("HospitalEmergencyDepartment");
            int port = 3306;
            String username = new String("root");
            String password = new String("");
            Connection con = DriverManager.getConnection(
                    url + ":" + port + "/" + databaseName + "?characterEncoding=UTF-8", username, password);

            System.out.println("DataBase connection is on");

            //Create Statement
            Statement myStmt = con.createStatement();
            //Execute SQL query
            ResultSet myRs = myStmt.executeQuery("select * from Doctor");

            //Process the result set
            while (myRs.next()){
                System.out.println(myRs.getString("First_Name") + ", " +
                        myRs.getString("Last_Name"));
            }


        }
        catch (Exception e){
            System.out.println("Connection Error " + e);
        }
    }


}