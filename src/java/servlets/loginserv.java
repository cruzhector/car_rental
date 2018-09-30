    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author kolip
 */
public class loginserv extends HttpServlet {

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
            throws ServletException, IOException, ParserConfigurationException, TransformerException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginserv at " + request.getContextPath() + "</h1>");
            
            
            
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
                        HttpSession session=request.getSession();
                        String em = null;
                
          
                   
                   
                   
                       try {
            
		con=(Connection)DriverManager.getConnection(url, user, password);
                out.println("connected");
                
                ps=con.prepareStatement("SELECT * FROM users WHERE email=? AND pass=?");
                ps.setString(1,request.getParameter("username") );
                ps.setString(2,request.getParameter("pass") );
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    session.setAttribute("email", request.getParameter("username"));
                    Cookie emailcook=new Cookie("email",request.getParameter("username"));
                    emailcook.setMaxAge(60*60*24);
                    emailcook.setHttpOnly(true);
                    response.addCookie(emailcook);
                    response.sendRedirect("home.jsp");
                    out.println("home");
                }
                
                  DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		  DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
		  //creating a new instance of a DOM to build a DOM tree.
		  Document doc = docBuilder.newDocument();
		  new loginserv().createXmlTree(doc,request.getParameter("username"),request.getParameter("pass"));
               
                //response.sendRedirect("index.html");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
      
        
            
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
    public void createXmlTree(Document doc,String username,String pass) throws TransformerConfigurationException, TransformerException, FileNotFoundException, IOException{
        
        Element root=doc.createElement("login");
        doc.appendChild(root);
        
        Element name_child=doc.createElement("username");
        root.appendChild(name_child);
        Text t=doc.createTextNode(username);
        name_child.appendChild(t);
        
        Element pass_child=doc.createElement("password");
        root.appendChild(pass_child);
        Text t1=doc.createTextNode(pass);
        pass_child.appendChild(t1);
        
        
         TransformerFactory factory = TransformerFactory.newInstance();
	  Transformer transformer = factory.newTransformer(); 
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
          
          
          StringWriter sw = new StringWriter();
	  StreamResult result = new StreamResult(sw);
	  DOMSource source = new DOMSource(doc);
	  transformer.transform(source, result);
	  String xmlString = sw.toString();

           File file = new File("D:/projects/Netbeans/swift/web/layouts/xmls/login.xml");
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	  bw.write(xmlString);
	  bw.flush();
	  bw.close();
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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(loginserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(loginserv.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(loginserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(loginserv.class.getName()).log(Level.SEVERE, null, ex);
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
