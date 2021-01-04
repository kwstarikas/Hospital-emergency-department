package Add;

import database.CS360DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddMed {


    public static void addMedicine (int Code, String name, Double Inclusiveness, String Disease_med, String Type)
            throws ClassNotFoundException, SQLException {


        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String ("INSERT INTO `Medicine` (`Code`, `Name`, `Inclusiveness`, `Disease_med`, `Type`) " +
                "VALUES ('"+ Code +"', '"+ name +"', '"+ Inclusiveness +"', '"+ Disease_med +"', '"+ Type +"');");

        stmt.executeUpdate(insQuery);
        con.close();

    }


    public static void addChronicDisease (int amka, String Date, String name)
            throws ClassNotFoundException, SQLException {


        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String ("INSERT INTO `ChronicCondition` (`AMKA`, `Diagnosis_date`, `Name`);" +
                "VALUES ('"+ amka +"', '"+ Date +"', '"+ name +"')");

        stmt.executeUpdate(insQuery);
        con.close();

    }










}
