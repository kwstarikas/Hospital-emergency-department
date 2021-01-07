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

/**
 *
 * @author loukas
 */
public class AddPeople {
    /**
     *
     * @param PID
     * @param name
     * @param LastName
     * @param Address
     * @param Birthadate
     * @param Phone
     * @param Sex
     * @param Specialization
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void addDoctor(int PID, String name, String LastName, String Address, String Birthadate,
            String Phone, String Sex, String Specialization)
            throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String("INSERT INTO `Doctor` (`PID`, `First_Name`, `Last_Name`, `Address`, "
                + "`Birthdate`, `Phone`, `Sex`, `Specialization`) \n"
                + "VALUES "
                + "(NULL, '" + name + "', '" + LastName + "', '" + Address + "', '" + Birthadate + "', '"
                + Phone + "', '" + Sex + "', '" + Specialization + "');");

        stmt.executeUpdate(insQuery);
        con.close();
    }

    /**
     *
     * @param PID
     * @param name
     * @param LastName
     * @param Address
     * @param Birthadate
     * @param Phone
     * @param Sex
     * @param Years_of_service
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void addAdminstrativeStaff(int PID, String name, String LastName, String Address, String Birthadate,
            String Phone, String Sex, String Years_of_service)
            throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String("INSERT INTO `Administrative staff` (`PID`, `First_Name`, `Last_Name`, `Address`, "
                + "`Birthdate`, `Phone`, `Sex`, `Years_of_service`) \n"
                + "VALUES "
                + "(NULL, '" + name + "', '" + LastName + "', '" + Address + "', '" + Birthadate + "', '"
                + Phone + "', '" + Sex + "', '" + Years_of_service + "');");

        stmt.executeUpdate(insQuery);
        con.close();

    }

    /**
     *
     * @param PID
     * @param name
     * @param LastName
     * @param Address
     * @param Birthadate
     * @param Phone
     * @param Sex
     * @param Expertise
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void addNurse(int PID, String name, String LastName, String Address, String Birthadate,
            String Phone, String Sex, String Expertise)
            throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();
        String insQuery = new String("INSERT INTO `Nurse` (`PID`, `First_Name`, `Last_Name`, `Address`, "
                + "`Birthdate`, `Phone`, `Sex`, `Expertise`) \n"
                + "VALUES "
                + "(NULL, '" + name + "', '" + LastName + "', '" + Address + "', '" + Birthadate + "', '"
                + Phone + "', '" + Sex + "', '" + Expertise + "');");

        stmt.executeUpdate(insQuery);
        con.close();
    }

    /**
     *
     * @param amka
     * @param name
     * @param Last_name
     * @param Address
     * @param Insurance
     * @param Phone
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void addPatient(int amka, String name, String Last_name, String Address, String Insurance, String Phone) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();

        int PID = addSymptoms(amka, "ponos");

        String insQuery = new String("INSERT INTO `Patient` (`AMKA`, `First_Name`, `Last_Name`, `Address`,"
                + " `Insurance`, `Phone`, `PID`) VALUES ('" + amka + "', 'ANDRONIKO', 'NIKOLO', 'IOANNINA', 'Agrotiki', '6984', '" + PID + "');");
        System.out.println("DONE");
        stmt.executeUpdate(insQuery);

    }

    /**
     *
     * @param amka
     * @param symptom
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int addSymptoms(int amka, String symptom) throws ClassNotFoundException, SQLException {
        int PID = 0;

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();

        /*
        * Exoume sinolo 5 astheneies gia 5 eidikotites
        * Bixas, kourasi, kardia , xtipima, ponokefalos
        * */
        if (symptom.equals("Bixas")) {
            String searchdoc = new String("SELECT PID FROM `Doctor` WHERE `Specialization` LIKE 'pathologos'");

            ResultSet rs = stmt.executeQuery(searchdoc);

            while (rs.next()) {
                PID = rs.getInt("PID");
            }
        } else if (symptom.equals("Kourasi")) {
            String searchdoc = new String("SELECT PID FROM `Doctor` WHERE `Specialization` LIKE 'pneumatologos'");

            ResultSet rs = stmt.executeQuery(searchdoc);

            while (rs.next()) {
                PID = rs.getInt("PID");
            }
        } else if (symptom.equals("kardia")) {
            String searchdoc = new String("SELECT PID FROM `Doctor` WHERE `Specialization` LIKE 'kardiologos'");

            ResultSet rs = stmt.executeQuery(searchdoc);

            while (rs.next()) {
                PID = rs.getInt("PID");
            }
        } else if (symptom.equals("xtipima")) {
            String searchdoc = new String("SELECT PID FROM `Doctor` WHERE `Specialization` LIKE 'Arthrologos'");

            ResultSet rs = stmt.executeQuery(searchdoc);

            while (rs.next()) {
                PID = rs.getInt("PID");
            }
        } else if (symptom.equals("ponokefalos")) {
            String searchdoc = new String("SELECT PID FROM `Doctor` WHERE `Specialization` LIKE 'se kati '");

            ResultSet rs = stmt.executeQuery(searchdoc);

            while (rs.next()) {
                PID = rs.getInt("PID");
            }
        }

        System.out.println("To pid einai : " + PID);

        String insQuery = new String("INSERT INTO `Symptoms` (`AMKA`, `Symptoms`) VALUES ( '" + amka
                + "','" + symptom + "');");

        stmt.executeUpdate(insQuery);
        return PID;
    }

    public static void addPreviousVisit(int amka, int Examination_ID, String Date, String Diagnosis, String Examination, String Cure)
            throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;
        con = CS360DB.getConnection();
        stmt = con.createStatement();

        String insQuery = new String("INSERT INTO `Previous visit` (`AMKA`, `ExaminationID`, `Date`, "
                + "`Diagnosis`, `Examination`, `Cure`) "
                + "VALUES ('" + amka + "', '" + Examination_ID + "', '" + Date + "', '" + Diagnosis + "',"
                + " '" + Examination + "', '" + Cure + "');");

        stmt.executeUpdate(insQuery);
        con.close();

    }

}
