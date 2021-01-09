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
public class RegisterPersonnelServlet extends HttpServlet {

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

            System.out.println("IN REGISTER PERSONNEL");
            String name = request.getParameter("Name");
//            String info = request.getParameter("AMKA");
//            int amka = Integer.parseInt(info);
            String surnname = request.getParameter("Surname");
            String address = request.getParameter("Address");
            String birthdate = request.getParameter("Birthdate");
            String phone = request.getParameter("Phone");
            String sex = request.getParameter("Sex");
            String type = request.getParameter("Extra");
            String typeValue = request.getParameter("ExtraVal");

            Statement stmt = null;
            Connection con = null;

            Map map = new HashMap();

            map.put("Type", type);
            map.put("First_Name", name);
            map.put("Last_Name", surnname);
            map.put("Address", address);
            map.put("Birthdate", birthdate);
            map.put("Phone", phone);
            map.put("Sex", sex);


            if (type.equals("Doctor")) {
                map.put("Valid", true);

                con = CS360DB.getConnection();
                stmt = con.createStatement();

                String insQuery = new String("INSERT INTO `Doctor` (`PID`, `First_Name`, `Last_Name`, `Address`, "
                        + "`Birthdate`, `Phone`, `Sex`, `Specialization`) \n"
                        + "VALUES "
                        + "(NULL, '" + name + "', '" + surnname + "', '" + address + "', '" + birthdate + "', '"
                        + phone + "', '" + sex + "', '" + typeValue + "');");

                map.put("ExtraVal", typeValue);
                map.put("Extra", "Specialization");
                stmt.executeUpdate(insQuery);

                System.out.println("Doctor '" + name + "' ADDED");

                con.close();

            } else if (type.equals("Nurse")) {
                map.put("Valid", true);

                con = CS360DB.getConnection();
                stmt = con.createStatement();

                String insQuery = new String("INSERT INTO `Nurse` (`PID`, `First_Name`, `Last_Name`, `Address`, "
                        + "`Birthdate`, `Phone`, `Sex`, `Expertise`) \n"
                        + "VALUES "
                        + "(NULL, '" + name + "', '" + surnname + "', '" + address + "', '" + birthdate + "', '"
                        + phone + "', '" + sex + "', '" + typeValue + "');");
                map.put("ExtraVal", typeValue);
                map.put("Extra", "Expertise");
                stmt.executeUpdate(insQuery);
                System.out.println("Nurse + '" + name + "' ADDED");
                con.close();

            } else if (type.equals("Administrative stuff")) {
                map.put("Valid", true);

                con = CS360DB.getConnection();
                stmt = con.createStatement();

                String insQuery = new String("INSERT INTO `Administrative staff` (`PID`, `First_Name`, `Last_Name`, `Address`, "
                        + "`Birthdate`, `Phone`, `Sex`, `Years_of_service`) \n"
                        + "VALUES "
                        + "(NULL, '" + name + "', '" + surnname + "', '" + address + "', '" + birthdate + "', '"
                        + phone + "', '" + sex + "', '" + typeValue + "');");

                map.put("ExtraVal", typeValue);
                map.put("Extra", "Years of servise");
                stmt.executeUpdate(insQuery);

                System.out.println("Administrative staff + '" + name + "' ADDED");
                con.close();
            } else
                map.put("Valid", false);

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
            Logger.getLogger(RegisterPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterPersonnelServlet.class.getName()).log(Level.SEVERE, null, ex);
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
