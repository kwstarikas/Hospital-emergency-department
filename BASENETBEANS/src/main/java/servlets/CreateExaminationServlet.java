/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import db.CS360DB;
import db.PatientDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author loukas
 */
public class CreateExaminationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String exType = request.getParameter("examType");
            System.out.println("Exam type : " + exType);
            System.out.println("IN Create EXAMINDED SERVLET");
            Map map = new HashMap();
            String info = request.getParameter("patient");
            int amka = Integer.parseInt(info);

            String date = request.getParameter("date");

            Connection con = CS360DB.getConnection();
            Statement stmt = con.createStatement();

            String insQuery = new String("SELECT * FROM `Nurse` WHERE "
                    + "`Expertise` LIKE '" + exType + "'");

            ResultSet rs = stmt.executeQuery(insQuery);

            int pid = -1;
            if (rs.next()) {
                pid = rs.getInt("PID");
            }

            con.close();

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = new String("INSERT INTO `Examination` "
                    + "(`Examination_ID`, `Date`, `type`, `PID`) "
                    + "VALUES (NULL, '" + date + "', '" + exType + "', '" + pid + "')");

            int exID = stmt.executeUpdate(insQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs1 = stmt.getGeneratedKeys();
            int lastExam = 0;
            if (rs1.next()) {
                lastExam = rs1.getInt(exID);

            }

            System.out.println("EXAMINATION INSERTED with log : " + lastExam);
            con.close();

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = new String("SELECT * FROM `Examination`"
                    + " WHERE `Examination_ID` = " + lastExam + " ");

            rs = stmt.executeQuery(insQuery);

            if (rs.next()) {
                map.put("ExamID", rs.getInt("Examination_ID"));
                map.put("NursePID", rs.getInt("PID"));
                map.put("ExamDate", date);
            }
            con.close();

            // pame na vroume disease
            con = CS360DB.getConnection();
            stmt = con.createStatement();
            insQuery = new String("SELECT * FROM `Symptoms` WHERE `AMKA` = " + amka + " ");

            String symptom = "";
            rs = stmt.executeQuery(insQuery);
            while (rs.next()) {
                symptom = new String(rs.getString("Symptoms"));
                System.out.println(" VRIKA TO SYMPTOMA : " + rs.getString("Symptoms"));
            }
            System.out.println(" AT LAST !!!! VRIKA TO SYMPTOMA (kai kala "
                    + "to teleutaio p egine insert) : " + symptom);

            con.close();

            String disease = PatientDB.getDisease(symptom);

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = new String("INSERT INTO `Diagnosis` "
                    + "(`Diagnosis_ID`, `AMKA`, `Name`, `Examination_ID`) VALUES "
                    + "(NULL, '" + amka + "', '" + disease + "', '" + lastExam + "')");

            int d = stmt.executeUpdate(insQuery, Statement.RETURN_GENERATED_KEYS);

            rs1 = stmt.getGeneratedKeys();
            int DiagnosisID = 0;
            if (rs1.next()) {
                DiagnosisID = rs1.getInt(d);

            }
            con.close();

            //////////////////////////////////////
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            String medicine = PatientDB.getMedicine(disease);

            insQuery = new String("SELECT Code FROM `Medicine` "
                    + "WHERE `Name` LIKE '" + medicine + "' ORDER BY `Name` DESC");

            rs = stmt.executeQuery(insQuery);

            int code = 0;

            if (rs.next()) {
                code = rs.getInt("Code");
            }

            con.close();

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = new String("INSERT INTO `Prescribes` (`Diagnosis_ID`, `Code`) "
                    + "VALUES ('" + DiagnosisID + "', '" + code + "')");
            stmt.executeUpdate(insQuery);

            con.close();

            map.put("Medicine", medicine);
            map.put("Disease", disease);

            Gson gson = new Gson();
            String json = gson.toJson(map);
            response.getWriter().write(json);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateExaminationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateExaminationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateExaminationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateExaminationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
