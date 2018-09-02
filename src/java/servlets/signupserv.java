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
public class signupserv extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParserConfigurationException, TransformerException {
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
                  DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		  DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
		  //creating a new instance of a DOM to build a DOM tree.
		  Document doc = docBuilder.newDocument();
		  new signupserv().createXmlTree(doc,request.getParameter("name"),request.getParameter("email"),request.getParameter("phnnum"),request.getParameter("dob"),request.getParameter("gender"),request.getParameter("pass"),request.getParameter("license"),request.getParameter("aadhar"));
                
                response.sendRedirect("login.jsp");
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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void createXmlTree(Document doc, String parameter, String parameter0, String parameter1, String parameter2, String parameter3, String parameter4, String parameter5, String parameter6) throws TransformerConfigurationException, TransformerException, FileNotFoundException, IOException{
        
        Element root=doc.createElement("ns:signup");
        doc.appendChild(root);
        
        Element name_child=doc.createElement("ns:username");
        root.appendChild(name_child);
        Text t=doc.createTextNode(parameter);
        name_child.appendChild(t);
        
        Element email_child=doc.createElement("ns:email");
        root.appendChild(email_child);
        Text t1=doc.createTextNode(parameter0);
        email_child.appendChild(t1);
        
         Element phn_child=doc.createElement("ns:phonenum");
        root.appendChild(phn_child);
        Text t2=doc.createTextNode(parameter1);
        phn_child.appendChild(t2);
        
        Element dob_child=doc.createElement("ns:dob");
        root.appendChild(dob_child);
        Text t3=doc.createTextNode(parameter2);
        dob_child.appendChild(t3);
        
        Element gen_child=doc.createElement("ns:gender");
        root.appendChild(gen_child);
        Text t4=doc.createTextNode(parameter3);
        gen_child.appendChild(t4);
        
        Element pass_child=doc.createElement("ns:password");
        root.appendChild(pass_child);
        Text t5=doc.createTextNode(parameter4);
        pass_child.appendChild(t5);
        
         Element lic_child=doc.createElement("ns:license");
        root.appendChild(lic_child);
        Text t6=doc.createTextNode(parameter5);
        lic_child.appendChild(t6);
        
        Element aadhar_child=doc.createElement("ns:aadhar");
        root.appendChild(aadhar_child);
        Text t7=doc.createTextNode(parameter6);
        aadhar_child.appendChild(t7);
        
       
    
    
          TransformerFactory factory = TransformerFactory.newInstance();
	  Transformer transformer = factory.newTransformer(); 
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
          
          
          StringWriter sw = new StringWriter();
	  StreamResult result = new StreamResult(sw);
	  DOMSource source = new DOMSource(doc);
	  transformer.transform(source, result);
	  String xmlString = sw.toString();

           File file = new File("D:/projects/Netbeans/swift/web/layouts/xmls/signup.xml");
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	  bw.write(xmlString);
	  bw.flush();
	  bw.close();
          
    
    }

 }
