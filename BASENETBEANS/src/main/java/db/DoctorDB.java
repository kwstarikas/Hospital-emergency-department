/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doctor;

/**
 *
 * @author loukas
 */
public class DoctorDB {
    public static Doctor getDoctor(int PID) throws ClassNotFoundException {
        Doctor doctor = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            String insQuery = new String("SELECT * FROM Doctor "
                    + "WHERE"
                    + "PID + '"
                    + PID + "';");

            stmt.execute(insQuery);

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                doctor = new Doctor();
                doctor.setPID(res.getInt("PID"));
                doctor.setFirst_Name(res.getString("First_Name"));
                doctor.setLast_Name(res.getString("Last_Name"));
                doctor.setAddress(res.getString("Address"));
                doctor.setBirthdate(res.getString("Birthdate"));
                doctor.setSex(res.getString("Sex"));
                doctor.setPhone(res.getString("Phone"));
                doctor.setSpecialization(res.getString("Specialization"));

            } else {
                System.out.println("Post with post id" + PID + "was not found");
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return doctor;

    }

    private static void closeDBConnection(Statement stmt, Connection con) {
        // Close connection
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
