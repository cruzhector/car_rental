/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kolip
 */
public class signupserv extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println ("<h1>Servlet signupserv at " + request.getContextPath() + "</h1>");
        out.println("dfds");
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
		con=(Connection)DriverManager.getConnection(url, user, password);
                out.println("connected");
                ps=con.prepareStatement("INSERT INTO users(name,email,phonenum,dob,gender,pass,license,aadhar) VALUES(?,?,?,?,?,?,?,?)");
                ps.setString(1,request.getParameter("name") );
                ps.setString(2,request.getParameter("email") );
                ps.setString(3,request.getParameter("phnnum") );
                ps.setString(4,request.getParameter("dob") );
                ps.setString(5,request.getParameter("gender") );
                ps.setString(6,request.getParameter("pass") );
                ps.setString(7,request.getParameter("license") );
                ps.setString(8,request.getParameter("aadhar") );
                ps.executeUpdate();
               
                out.println("inserted");
                //response.sendRedirect("index.html");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        finally{
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
        
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
 }
