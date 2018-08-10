/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import getsets.homegetset;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kolip
 */
public class homeserv extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet homeserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homeserv at " + request.getContextPath() + "</h1>");
           
           
           
            String DRIVER="com.mysql.jdbc.Driver";  
             
             
              try {
		Class.forName(DRIVER);
		out.println("success");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
                
	String url="jdbc:mysql://localhost/carrental";
	String user="root";
	String password="hector1998";
	Connection con=null;
        PreparedStatement ps=null;
	try {
            HttpSession session=request.getSession();
            ArrayList<carsgetset> ar=new ArrayList<>();
           final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

            
		con=(Connection)DriverManager.getConnection(url, user, password);
                out.println("connected");
                ps=con.prepareStatement("SELECT * FROM carstable WHERE carname NOT IN(SELECT carname FROM booking WHERE(fromdate <= '"+request.getParameter("ddate")+"') AND (todate >= '"+request.getParameter("pdate")+"'))");
              
                ResultSet rs=ps.executeQuery();
                
                 while(rs.next()){
                      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                      Date date1 = sdf.parse(request.getParameter("ddate"));
                      Date date2 = sdf.parse(request.getParameter("pdate"));
                      int diffInDays = (int) ((date1.getTime() - date2.getTime())/ DAY_IN_MILLIS );
                      int cost=rs.getInt("cost")+(rs.getInt("cost")*(diffInDays/2));
                     ar.add(new carsgetset(rs.getString("carname"),rs.getString("cartype"),rs.getString("transmission"),rs.getString("seats"),cost,rs.getString("image")));
                     
                 }
                 
            session.setAttribute("city", request.getParameter("pickup"));
            session.setAttribute("from", request.getParameter("pdate"));
            session.setAttribute("to", request.getParameter("ddate"));
            session.setAttribute("carlist", ar);
            session.setAttribute("carlistsize", String.valueOf(ar.size()));

            response.sendRedirect("carsdisplay.jsp");

	} catch (SQLException e) {
		e.printStackTrace();
	}
           
            
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
        } catch (ParseException ex) {
            Logger.getLogger(homeserv.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(homeserv.class.getName()).log(Level.SEVERE, null, ex);
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
