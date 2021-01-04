package procedures;

import database.CS360DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Prescribes {

    public static void addPrescribe(int Diagnosis_ID, int Code) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();

        String insQuery = new String ("INSERT INTO `Prescribes` (`Diagnosis_ID`, `Code`) VALUES" +
                " ('"+ Diagnosis_ID +"', '"+ Code +"');");

        stmt.executeUpdate(insQuery);
        con.close();
    }


}
