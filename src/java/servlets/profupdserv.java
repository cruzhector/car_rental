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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author kolip
 */
public class profupdserv extends HttpServlet {

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
            out.println("<title>Servlet profupdserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profupdserv at " + request.getContextPath() + "</h1>");
            
            String DRIVER="com.mysql.jdbc.Driver";  
             
             
              try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
                
	String url="jdbc:mysql://localhost/carrental";
	String user="root";
	String password="hector1998";
	Connection con=null;
        Statement ps=null;
        String sql=null;
	try {
           
		con=(Connection)DriverManager.getConnection(url, user, password);
                out.println("Successfully Updated"); 
                sql="UPDATE users SET name='"+request.getParameter("name")+"',phonenum='"+request.getParameter("phnnum")+"',dob='"+request.getParameter("dob")+"',gender='"+request.getParameter("gender")+"',license='"+request.getParameter("license")+"',aadhar='"+request.getParameter("aadhar")+"'"
                        + "WHERE email='"+request.getParameter("email")+"'";
                ps=con.createStatement();
                ps.executeUpdate(sql);
             
                
                
            
             DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		  DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
		  //creating a new instance of a DOM to build a DOM tree.
		  Document doc = docBuilder.newDocument();
            new profupdserv().createXmlTree(doc,request.getParameter("name"), request.getParameter("email"), request.getParameter("phnnum"), request.getParameter("dob"), request.getParameter("gender"), request.getParameter("license"), request.getParameter("aadhar"));
            
            response.sendRedirect("profile.jsp");

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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(profupdserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(profupdserv.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(profupdserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(profupdserv.class.getName()).log(Level.SEVERE, null, ex);
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

    private void createXmlTree(Document doc, String parameter, String parameter0, String parameter1, String parameter2, String parameter3, String parameter4, String parameter5) throws TransformerConfigurationException, TransformerException, FileNotFoundException, IOException{
          Element root=doc.createElement("profile");
        doc.appendChild(root);
        
        Element name_child=doc.createElement("username");
        root.appendChild(name_child);
        Text t=doc.createTextNode(parameter);
        name_child.appendChild(t);
        
        Element email_child=doc.createElement("email");
        root.appendChild(email_child);
        Text t1=doc.createTextNode(parameter0);
        email_child.appendChild(t1);
        
         Element phn_child=doc.createElement("phonenum");
        root.appendChild(phn_child);
        Text t2=doc.createTextNode(parameter1);
        phn_child.appendChild(t2);
        
        Element dob_child=doc.createElement("dob");
        root.appendChild(dob_child);
        Text t3=doc.createTextNode(parameter2);
        dob_child.appendChild(t3);
        
        Element gen_child=doc.createElement("gender");
        root.appendChild(gen_child);
        Text t4=doc.createTextNode(parameter3);
        gen_child.appendChild(t4);
     
        
         Element lic_child=doc.createElement("license");
        root.appendChild(lic_child);
        Text t6=doc.createTextNode(parameter4);
        lic_child.appendChild(t6);
        
        Element aadhar_child=doc.createElement("aadhar");
        root.appendChild(aadhar_child);
        Text t7=doc.createTextNode(parameter5);
        aadhar_child.appendChild(t7);
        
       
    
    
          TransformerFactory factory = TransformerFactory.newInstance();
	  Transformer transformer = factory.newTransformer(); 
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
          
          
          StringWriter sw = new StringWriter();
	  StreamResult result = new StreamResult(sw);
	  DOMSource source = new DOMSource(doc);
	  transformer.transform(source, result);
	  String xmlString = sw.toString();

           File file = new File("D:/projects/Netbeans/swift/web/layouts/xmls/profile.xml");
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	  bw.write(xmlString);
	  bw.flush();
	  bw.close();

    }

}
