/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import db.CS360DB;
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
import model.Patient;

/**
 *
 * @author loukas
 */
public class LoginPatientServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            boolean correct = false; //if the patient exists
            Connection con = CS360DB.getConnection();
            Statement stmt = con.createStatement();
            String info = request.getParameter("amka");
            int amka = Integer.parseInt(info);

            System.out.println("ENTER THE SERVLET");

            String insQuery = new String("SELECT * FROM `Patient` WHERE `AMKA` = " + amka);
            ResultSet rs = stmt.executeQuery(insQuery);
            Patient patient;
            patient = new Patient();
            Map map = new HashMap();
            if (rs.next()) {
                System.out.println("Found him");
                map.put("Exists", true);
                map.put("AMKA", rs.getInt("AMKA"));
                map.put("First_Name", rs.getString("First_Name"));
                map.put("Last_Name", rs.getString("Last_Name"));
                map.put("Address", rs.getString("Address"));
                map.put("Insurance", rs.getString("Insurance"));
                map.put("Phone", rs.getString("Phone"));
                map.put("PID", rs.getInt("PID"));

            } else {
                map.put("Exists", false);
            }

            insQuery = new String("SELECT * FROM `Previous visit` WHERE `AMKA` = " + amka);
            rs = stmt.executeQuery(insQuery);

            if (rs.next()) {
                map.put("Has_Prev_visit", true);
                map.put("AMKA", rs.getInt("AMKA"));
                map.put("ExaminationID", rs.getString("ExaminationID"));
                map.put("Date", rs.getString("Date"));
                map.put("Diagnosis", rs.getString("Diagnosis"));
                map.put("Examination", rs.getString("Examination"));
                map.put("Cure", rs.getString("Cure"));
            } else {
                map.put("Has_Prev_visit", false);
            }

            insQuery = new String("SELECT * FROM `ChronicCondition` WHERE `AMKA` = " + amka);
            rs = stmt.executeQuery(insQuery);
            if (rs.next()) {
                map.put("ChronicDisease", rs.getString("Name"));
                map.put("DiagnosisDate", rs.getString("Diagnosis_date"));
            }
            else
                map.put("ChronicDisease", false);
            Gson gson = new Gson();
            String json = gson.toJson(map);
            response.getWriter().write(json);
            con.close();
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
