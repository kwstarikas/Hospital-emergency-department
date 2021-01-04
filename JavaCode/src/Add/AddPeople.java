package Add;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import database.CS360DB;
public class AddPeople {


    public static void addDoctor () throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String ("INSERT INTO `Doctor` (`PID`, `First_Name`, `Last_Name`, `Address`, `Birthdate`, `Phone`, `Sex`, `Specialization`) \n" +
                "VALUES (NULL, 'Andreas', 'Katsarakis', 'kritovoulidou 1 Heraklion', '2021-01-21', '63658525', 'male', 'Pathologos'), \n" +
                "(NULL, 'Zhnovia', 'Xouridi', 'who knows', '2021-01-30', '85625625', 'female', 'Podologos');");

        stmt.executeUpdate(insQuery);
        con.close();
    }



}
