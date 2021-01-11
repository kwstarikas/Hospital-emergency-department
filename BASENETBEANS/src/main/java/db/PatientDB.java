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
import model.Patient;


/**
 *
 * @author loukas
 */
public class PatientDB {

    public static String getMedicine(String disease) {
        String med = null;

        if (disease.equals("Fracture")) {
            med = new String("Lexotanil");
        } else if (disease.equals("Migraine")) {
            med = new String("Nurofen");
        } else if (disease.equals("Gastrenteritida")) {
            med = new String("Perfan");
        } else if (disease.equals("Gastrenteritida")) {
            med = new String("Imodium");
        } else if (disease.equals("kardiaki aneparkeia")) {
            med = new String("Perfan");
        } else if (disease.equals("Covid")) {
            med = new String("Covid Vacine");
        }

        return med;

    }

    public static int fetchdoc(String spec) throws SQLException, ClassNotFoundException {
        int pid = 0;

        Connection con = CS360DB.getConnection();
        Statement stmt = con.createStatement();

        String insQuery = new String("SELECT * FROM `Doctor` WHERE `Specialization` "
                + "LIKE '" + spec + "' ORDER BY `Specialization` DESC");

        ResultSet rs = stmt.executeQuery(insQuery);

        if (rs.next()) {
            pid = rs.getInt("PID");
        }
        System.out.println("FETCH DONE WITH PID : " + pid);
        return pid;
    }

    public static int getDoctor(String symptom) throws SQLException, ClassNotFoundException {
        int pid = 0;
        System.out.print("in Get Doc");

        if (symptom.equals("Wound")) {
            pid = fetchdoc("arthrologos");
        } else if (symptom.equals("Headache")) {
            pid = fetchdoc("pathologos");
        } else if (symptom.equals("Stomachache")) {
            pid = fetchdoc("pneumatologos");
        } else if (symptom.equals("Abdominal pain ")) {
            pid = fetchdoc("kardiologos");
        } else if (symptom.equals("Weariness")) {
            pid = fetchdoc("covid");
        }

        return pid;
    }

    public static String getDisease(String symptom) {

        String disease = null;
        System.out.println("START GOT DISEASE : " + disease);
        if (symptom.equals("Wound")) {
            disease = new String("Fracture");
        } else if (symptom.equals("Headache")) {
            disease = new String("Migraine");
        } else if (symptom.equals("Stomachache")) {
            disease = new String("Gastrenteritida");
        } else if (symptom.equals("Abdominal pain")) {
            disease = new String("kardiaki aneparkeia");
        } else if (symptom.equals("Weariness")) {
            disease = new String("Covid");
        }


        System.out.println("END GOT DISEASE : " + disease);
        return disease;
    }

    public static Patient getPatient(int amka) throws ClassNotFoundException {
        System.out.print("INTO GET PATIENT");
        Patient patient = null;
        Statement stmt = null;
        Connection con = null;

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            String insQuery = new String("SELECT * FROM"
                    + "'Patient' WHERE"
                    + "'AMKA' = " + amka);

            ResultSet rs = stmt.executeQuery(insQuery);

            while (rs.next()) {
                patient = new Patient();
                patient.setAmka(rs.getInt("AMKA"));
                patient.setFirst_Name(rs.getString("First_Name"));
                patient.setLast_Name(rs.getString("Last_Name"));
                patient.setAddress(rs.getString("Address"));
                patient.setInsurance(rs.getString("Incurance"));
                patient.setPhone(rs.getString("Phone"));
                patient.setPID(rs.getInt("PID"));
            }

        } catch (SQLException ex) {
            //Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return patient;
    }

    public static void addPatient(int amka, String name, String surname,
            String address, String insurance, String phone, int pid) throws ClassNotFoundException {

        System.out.print("INTO ADD PATIENT");
        Patient patient = null;
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            String insQuery = new String("INSERT INTO `Patient` "
                    + "(`AMKA`, `First_Name`, `Last_Name`, `Address`, `Insurance`, "
                    + "`Phone`, `PID`) "
                    + "VALUES"
                    + " ('" + amka + "', '" + name + "', '" + surname + "', '" + address + "', "
                    + "'" + insurance + "', '" + phone + "', '0');");

//            PreparedStatement insPatient = con.prepareStatement(insQuery);
            stmt.executeUpdate(insQuery);

        } catch (SQLException ex) {
            //Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

    }


    private static void closeDBConnection(Statement stmt, Connection con) {
        // Close connection
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                // Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
