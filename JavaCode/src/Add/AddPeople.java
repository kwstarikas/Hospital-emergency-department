package Add;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.CS360DB;

import javax.swing.plaf.nimbus.State;

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

    public static void addPatient (int amka) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        int PID = 39;
        //int PID = addSymptoms(amka, "ponos");


        String insQuery = new String ("INSERT INTO `Patient` (`AMKA`, `First_Name`, `Last_Name`, `Address`," +
                    " `Insurance`, `Phone`, `PID`) VALUES ('" + amka + "', 'ANDRONIKO', 'NIKOLO', 'IOANNINA', 'Agrotiki', '6984', '"+PID+"')");
        System.out.println("DONE");
        stmt.executeUpdate(insQuery);

    }

    public static int addSymptoms (int amka, String symptom) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();

        int PID = 0;

        if (symptom.equals("Bixas")) {
            String searchdoc = new String ("SELECT PID FROM `Doctor` WHERE `Specialization` LIKE 'pathologos'");

            ResultSet rs =stmt.executeQuery(searchdoc);

            while (rs.next()) {
                PID = rs.getInt("PID");
            }
        }



        System.out.println("To pid einai : " + PID);

        String insQuery = new String ("INSERT INTO `Symptoms` (`AMKA`, `Symptoms`) VALUES ( '" + amka
                +"','"+ symptom +"');");

        stmt.executeUpdate(insQuery);
        return PID;
    }


    public static void addPreviousVisit () throws ClassNotFoundException, SQLException {



    }
}









































