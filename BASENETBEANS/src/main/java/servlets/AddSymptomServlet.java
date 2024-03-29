/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import db.AddPeople;
import db.CS360DB;
import db.PatientDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class AddSymptomServlet extends HttpServlet {

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
            System.out.println("IN ADD SYMPTOM SERVLET");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            boolean correct = false; //if the patient exists

            Connection con = CS360DB.getConnection();
            Statement stmt = con.createStatement();

            String symptom = request.getParameter("symptom");
            String info = request.getParameter("amka");
            int amka = Integer.parseInt(info);

            String insQuery = new String("INSERT INTO `Symptoms` "
                    + "(`AMKA`, `Symptoms`) "
                    + "VALUES ('" + amka + "', '" + symptom + "')");

            stmt.executeUpdate(insQuery);

            con.close();
            Map map = new HashMap();

            int pid = PatientDB.getDoctor(symptom);

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = new String("UPDATE `Patient` SET "
                    + "`PID` = '" + pid + "' WHERE `Patient`.`AMKA` = " + amka + " ;");
            stmt.executeUpdate(insQuery);

            con.close();
            map.put("DOC", AddPeople.addSymptoms(amka, symptom));

            //ADD TO SHIFT/////////////////////
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            insQuery = new String("SELECT * FROM `Shift` "
                    + "WHERE `Date` = '" + dtf.format(now) + "'");
            ResultSet rs = stmt.executeQuery(insQuery);
            int ShiftID = 0;
            if (rs.next()) {
                ShiftID = rs.getInt("Shift_ID");
            }
            con.close();

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            if (ShiftID > 0) {
                insQuery = new String("INSERT INTO `OnShift` (`ID`, `PPID`, `Date`) "
                        + "VALUES ('" + ShiftID + "', '" + amka + "', '" + dtf.format(now) + "')");
                stmt.executeUpdate(insQuery);
                con.close();
            } else
                System.out.print("INVALID DATE");

            ///////////////////////////////////

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
        } catch (SQLException ex) {
            Logger.getLogger(AddSymptomServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddSymptomServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddSymptomServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddSymptomServlet.class.getName()).log(Level.SEVERE, null, ex);
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
