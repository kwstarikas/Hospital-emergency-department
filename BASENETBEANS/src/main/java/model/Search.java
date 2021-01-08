/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.CS360DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author loukas
 */
public class Search {

    public static Patient searchPatient(int Code) throws SQLException, ClassNotFoundException {
        System.out.println("IN SEARCH");
        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        int PID = 0;
        Patient patient = null;

        String insQuery = new String("SELECT * FROM `Patient`"
                + "WHERE `AMKA` = " + Code);
        System.out.print("insQuery");
        ResultSet rs = stmt.executeQuery(insQuery);

        while (rs.next()) {
            System.out.println(" MPIKA WHILE");
            patient = new Patient();
            patient.setAmka(rs.getInt("AMKA"));
            patient.setFirst_Name(rs.getString("First_Name"));
            patient.setLast_Name(rs.getString("Last_Name"));
            patient.setAddress(rs.getString("Address"));
            patient.setInsurance(rs.getString("Incurance"));
            patient.setPhone(rs.getString("Phone"));
            patient.setPID(rs.getInt("PID"));

        }

        return patient;
    }

}
