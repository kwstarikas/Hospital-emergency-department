/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.CS360DB;
import db.PatientDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
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
public class getExaminedServlet extends HttpServlet {

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

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            System.out.println("IN GET EXAMINDED SERVLET");

            String symptom = request.getParameter("symptom");
            String info = request.getParameter("amka");
            int amka = Integer.parseInt(info);

            Connection con = CS360DB.getConnection();
            Statement stmt = con.createStatement();

            String disease = PatientDB.getDisease(symptom);

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            String insQuery = new String("INSERT INTO `Diagnosis` (`Diagnosis_ID`, `Time`) "
                    + "VALUES (NULL, " + timestamp + ")");
            stmt.executeUpdate(insQuery);
            con.close();

//            con = CS360DB.getConnection();
//            stmt = con.createStatement();
//
//            insQuery = new String("SELECT LAST_INSERT_ID();");
//
//            ResultSet rs = stmt.executeQuery(insQuery);
//
//            int DiagnosisID = -1;
//            while (rs.next()) {
//                DiagnosisID = rs.getInt("Diagnosis_ID");
//                System.out.println("VRIKA TO DIAGNOISIS ID :" + DiagnosisID);
//            }
//
//            con.close();
//
//            con = CS360DB.getConnection();
//            stmt = con.createStatement();
//
//            insQuery = new String("INSERT INTO `Disease` (`Diagnosis_ID`, `Disease`) "
//                    + "VALUES ('" + DiagnosisID + "', '" + disease + "')");
//            stmt.executeUpdate(insQuery);
//            con.close();
//
//            String medicine = PatientDB.getMedicine(disease);
//
//            con = CS360DB.getConnection();
//            stmt = con.createStatement();
//
//            insQuery = new String("SELECT Code FROM `Medicine` "
//                    + "WHERE `Name` LIKE '" + medicine + "' ORDER BY `Name` DESC");
//
//
//            rs = stmt.executeQuery(insQuery);
//
//            int code = 0;
//
//            if (rs.next()) {
//                code = rs.getInt("Code");
//            }
//
//            con.close();
//
//            con = CS360DB.getConnection();
//            stmt = con.createStatement();
//
//            insQuery = new String("INSERT INTO `Prescribes` (`Diagnosis_ID`, `Code`) "
//                    + "VALUES ('" + DiagnosisID + "', '" + code + "')");
//            rs = stmt.executeQuery(insQuery);
//
//            con.close();
//
//            Map map = new HashMap();
//
//            map.put("MED", true);
//            map.put("Disease", disease);
//            map.put("Medicine", medicine);
//
//            Gson gson = new Gson();
//            String json = gson.toJson(map);
//            response.getWriter().write(json);


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
            Logger.getLogger(getExaminedServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getExaminedServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getExaminedServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getExaminedServlet.class.getName()).log(Level.SEVERE, null, ex);
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
