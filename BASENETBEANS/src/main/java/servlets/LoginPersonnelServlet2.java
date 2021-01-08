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

/**
 *
 * @author loukas
 */
public class LoginPersonnelServlet2 extends HttpServlet {

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
            System.out.println("IN Login PERSONNEL SERVLET");

            Connection con = CS360DB.getConnection();
            Statement stmt = con.createStatement();
            boolean done = false;
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            Map map = new HashMap();
            String info = request.getParameter("pid");
            int pid = Integer.parseInt(info);
            System.out.println("Paw na vrw personnel me pid : " + pid);
            //search doc
            String insQuery = new String("SELECT * FROM `Doctor`"
                    + " WHERE `PID` =" + pid);
            ResultSet docrs = stmt.executeQuery(insQuery);
//
//            //search nurse
//            String insQueryn = new String("SELECT * FROM `Nurse`"
//                    + " WHERE `PID` =" + pid);
//            ResultSet nursers = stmt.executeQuery(insQueryn);
//

            // 0 for doc 1 for nurse 2 for admin
            if (docrs.next()) {
                done = true;
                map.put("Exists", true);
                map.put("Type", 0);
                map.put("PID", docrs.getInt("PID"));
                map.put("First_Name", docrs.getString("First_Name"));
                map.put("Last_Name", docrs.getString("Last_Name"));
                map.put("Address", docrs.getString("Address"));
                map.put("Birthdate", docrs.getString("Birthdate"));
                map.put("Phone", docrs.getString("Phone"));
                map.put("Sex", docrs.getString("Sex"));
                map.put("Extra", docrs.getString("Specialization"));
            }
            con.close();

            con = CS360DB.getConnection();
            stmt = con.createStatement();

//            search nurse
            String insQueryn = new String("SELECT * FROM `Nurse`"
                    + " WHERE `PID` =" + pid);
            ResultSet nursers = stmt.executeQuery(insQueryn);
            if (nursers.next()) {
                done = true;
                map.put("Exists", true);
                map.put("Type", 1);
                map.put("PID", nursers.getInt("PID"));
                map.put("First_Name", nursers.getString("First_Name"));
                map.put("Last_Name", nursers.getString("Last_Name"));
                map.put("Address", nursers.getString("Address"));
                map.put("Birthdate", nursers.getString("Birthdate"));
                map.put("Phone", nursers.getString("Phone"));
                map.put("Sex", nursers.getString("Sex"));
                map.put("Extra", nursers.getString("Expertise"));
            }
            con.close();
            con = CS360DB.getConnection();
            stmt = con.createStatement();
//            // search ADMIN
            String insQuerya = new String("SELECT * FROM `Administrative staff` "
                    + "WHERE `PID` =" + pid);
            ResultSet adminrs = stmt.executeQuery(insQuerya);

            if (adminrs.next()) {
                done = true;
                map.put("Exists", true);
                map.put("Type", 2);
                map.put("PID", adminrs.getInt("PID"));
                map.put("First_Name", adminrs.getString("First_Name"));
                map.put("Last_Name", adminrs.getString("Last_Name"));
                map.put("Address", adminrs.getString("Address"));
                map.put("Birthdate", adminrs.getString("Birthdate"));
                map.put("Phone", adminrs.getString("Phone"));
                map.put("Sex", adminrs.getString("Sex"));
                map.put("Extra", adminrs.getInt("Years_of_service"));
            }
            if (!done) {
                map.put("Exists", false);
            }

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
            Logger.getLogger(LoginPersonnelServlet2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPersonnelServlet2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginPersonnelServlet2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPersonnelServlet2.class.getName()).log(Level.SEVERE, null, ex);
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
