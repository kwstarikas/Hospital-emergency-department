/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author loukas
 */
public class AddMed {
    public static void addMedicine(int Code, String name, Double Inclusiveness, String Disease_med, String Type)
            throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String("INSERT INTO `Medicine` (`Code`, `Name`, `Inclusiveness`, `Disease_med`, `Type`) "
                + "VALUES ('" + Code + "', '" + name + "', '" + Inclusiveness + "', '" + Disease_med + "', '" + Type + "');");

        stmt.executeUpdate(insQuery);
        con.close();

    }

    public static void addPeople(String[] dude, int shift, String date) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;

        String insQuery = new String();

        for (int i = 0; i < dude.length; i++) {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = "INSERT INTO `OnShift` (`ID`, `PPID`, `Date`) "
                    + "VALUES ('" + shift + "', '" + dude[i] + "', '" + date + "')";

            stmt.executeUpdate(insQuery);
            con.close();

        }

        System.out.print("INSERT ARRAY INTO SHIFT");
    }

    public static void addChronicDisease(int amka, String Date, String name)
            throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String("INSERT INTO `ChronicCondition` (`AMKA`, `Diagnosis_date`, `Name`);"
                + "VALUES ('" + amka + "', '" + Date + "', '" + name + "')");

        stmt.executeUpdate(insQuery);
        con.close();

    }

}
