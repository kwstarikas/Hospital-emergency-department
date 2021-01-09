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
import model.AdminstrativeStaff;
import model.Doctor;
import model.Nurse;

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
                    + "'PID' ="
                    + PID);

            ResultSet res = stmt.executeQuery(insQuery);

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
                System.out.println("Doc with doc id " + PID + " was not found");
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

    public static Nurse getNurse(int PID) throws ClassNotFoundException {
        Nurse nurse = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            String insQuery = new String("SELECT * FROM `Nurse` "
                    + "WHERE `PID` = 9" + PID);

            ResultSet res = stmt.executeQuery(insQuery);


            if (res.next() == true) {
                nurse = new Nurse();
                nurse.setPID(res.getInt("PID"));
                nurse.setFirst_Name(res.getString("First_Name"));
                nurse.setLast_Name(res.getString("Last_Name"));
                nurse.setAddress(res.getString("Address"));
                nurse.setBirthdate(res.getString("Birthdate"));
                nurse.setSex(res.getString("Sex"));
                nurse.setPhone(res.getString("Phone"));
                nurse.setExpertise(res.getString("Expertise"));

            } else {
                System.out.println("Nurse with Nurse id " + PID + " was not found");
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return nurse;

    }

    public static AdminstrativeStaff getAdminstrativeStaff(int PID) throws ClassNotFoundException {

        AdminstrativeStaff adminstrativeStaff = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            String insQuery = new String("SELECT * FROM `Administrative staff`"
                    + " WHERE `PID` =" + PID);

            ResultSet res = stmt.executeQuery(insQuery);


            if (res.next() == true) {
                adminstrativeStaff = new AdminstrativeStaff();
                adminstrativeStaff.setPID(res.getInt("PID"));
                adminstrativeStaff.setFirst_Name(res.getString("First_Name"));
                adminstrativeStaff.setLast_Name(res.getString("Last_Name"));
                adminstrativeStaff.setAddress(res.getString("Address"));
                adminstrativeStaff.setBirthdate(res.getString("Birthdate"));
                adminstrativeStaff.setSex(res.getString("Sex"));
                adminstrativeStaff.setPhone(res.getString("Phone"));
                adminstrativeStaff.setYears_of_service(res.getInt("Years_of_service"));

            } else {
                System.out.println("adminstrativeStaff with NuradminstrativeStaff id " + PID + " was not found");
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return adminstrativeStaff;

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
