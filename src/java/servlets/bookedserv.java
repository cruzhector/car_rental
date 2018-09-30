/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kolip
 */
public class bookedserv extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet bookedserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bookedserv at " + request.getContextPath() + "</h1>");
            
            HttpSession sess=request.getSession();
            
           Connection cons =connection.con();
            Statement st=cons.createStatement();
            
            String date=LocalDate.now().toString();
            out.println(date);
            ArrayList<bookedgetset> ar=new ArrayList<>();
            String sql="SELECT * FROM booking WHERE (fromdate>'"+date+"') AND (email='"+sess.getAttribute("email")+"')";
//            String xsql="SELECT * FROM booking WHERE (fromdate >= '2018-09-30') AND (email = 'kolipakarama@gmail.com')";
            ResultSet rs=st.executeQuery(sql);

            while(rs.next()){
                

                String carimg="SELECT * FROM carstable WHERE carname='"+rs.getString("carname")+"'";
                Statement st1=cons.createStatement();
                ResultSet rs1=st1.executeQuery(carimg);
              


                String img=null;
                out.println(rs.getString("fromdate"));
                out.println(rs.getString("todate"));
                while(rs1.next()){
                    img=rs1.getString("image");
                    out.println(img);
}
             ar.add(new bookedgetset(rs.getString("carname"),img,rs.getString("fromdate"),rs.getString("todate")));

            }

            sess.setAttribute("upcoming", ar);
                        request.getRequestDispatcher("/booked.jsp").forward(request, response);  
            
            out.println("</body>");
            out.println("</html>");
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
            Logger.getLogger(bookedserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookedserv.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(bookedserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookedserv.class.getName()).log(Level.SEVERE, null, ex);
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
