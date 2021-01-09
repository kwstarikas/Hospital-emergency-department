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
public class RegisterPatientServlet extends HttpServlet {

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
            System.out.println("IN ADD PATIENT REGISTER SERVLET");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            Statement stmt = null;
            Connection con = null;

            String name = request.getParameter("Name");
            String info = request.getParameter("AMKA");
            int amka = Integer.parseInt(info);
            String surnname = request.getParameter("Surname");
            String address = request.getParameter("Address");
            String insurance = request.getParameter("Insurance");
            String phone = request.getParameter("Phone");
            String chronicDisease = request.getParameter("CronicDiseases");
            String chronicDate = request.getParameter("ChronicDiseaseDate");

            Map map = new HashMap();

            map.put("First_Name", name);
            map.put("Last_Name", surnname);
            map.put("Address", address);
            map.put("AMKA", amka);
            map.put("Phone", phone);
            map.put("Insurance", insurance);
            map.put("PID", 0);
            map.put("Chronic", chronicDisease);
            map.put("ChronicDate", chronicDate);
            map.put("PID", 0);

            System.out.println(name);
            System.out.println(amka);
            System.out.println(surnname);
            System.out.println(address);
            System.out.println(insurance);
            System.out.println(phone);
            System.out.println(chronicDisease);

            PatientDB.addPatient(amka, name, surnname, address,
                    insurance, phone, 0);

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            String insQuery = new String("INSERT INTO `ChronicCondition` "
                    + "(`AMKA`, `Diagnosis_date`, `Name`) "
                    + "VALUES ('" + amka + "', '" + chronicDate + "', '" + chronicDisease + "')");

            stmt.executeUpdate(insQuery);
            con.close();

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
            Logger.getLogger(RegisterPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
