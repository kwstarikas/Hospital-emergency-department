/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.CS360DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Doctor;

/**
 *
 * @author loukas
 */
public class LoginPersonnelServlet extends HttpServlet {

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
            // 0 for doctor 1 for nurse 2 for adminstrative stuff
            int PersonnelKind = -1; //
            Connection con = CS360DB.getConnection();
            Statement stmt = con.createStatement();
            String info = request.getParameter("PersonnelLoginInfo");
            int pid = Integer.parseInt(info);

            String insQuery = new String("SELECT * FROM `Doctor` WHERE `PID` = " + pid);
            ResultSet rsDoc = stmt.executeQuery(insQuery);

            insQuery = new String("SELECT * FROM `Nurse` WHERE `PID` = " + pid);
            ResultSet rsNurse = stmt.executeQuery(insQuery);

            insQuery = new String("SELECT * FROM `Administrative staff` WHERE `PID` = " + pid);
            ResultSet rsAdmin = stmt.executeQuery(insQuery);

            if (rsDoc != null) {
                //exoume prosopiko giatrou do stuff
                Doctor doctor = new Doctor();

            } else if (rsNurse != null) {
                //exoume prosopiko nurse do stuff
            } else if (rsAdmin != null) {
                // exoume prosopiko admin do stuff
            } else {
                //den uparxei to proswpiko 
            }


            out.println("<html><body>");
            String message = "EIMAI O RIKAS me amka : "
                    + "";
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
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
            Logger.getLogger(LoginPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
