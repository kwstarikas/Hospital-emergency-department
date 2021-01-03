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

            System.out.println("Connection is on");


            //Create Statement
            Statement myStmt = con.createStatement();
            //Execute SQL query
            ResultSet myRs = myStmt.executeQuery("select * from Patient");

            //Process the result set
            while (myRs.next()){
                System.out.println(myRs.getString("First_Name") + ", " +
                        myRs.getString("Last_Name"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
    
    
}
