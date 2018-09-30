/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import getsets.homegetset;
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
            throws ServletException, IOException, ParseException, ParserConfigurationException, TransformerException {
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
                              out.println("came");

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
            
             DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		  DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
		  //creating a new instance of a DOM to build a DOM tree.
		  Document doc = docBuilder.newDocument();
		  new homeserv().createXmlTree(doc,request.getParameter("pickup"),request.getParameter("pdate"),request.getParameter("ddate"));
                
            

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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(homeserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
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
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(homeserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
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

    private void createXmlTree(Document doc, String parameter, String parameter0, String parameter1) throws TransformerConfigurationException, TransformerException, FileNotFoundException, IOException{  
    
     Element root=doc.createElement("home");
        doc.appendChild(root);
        
        Element pickup_child=doc.createElement("pickup");
        root.appendChild(pickup_child);
        Text t=doc.createTextNode(parameter);
        pickup_child.appendChild(t);
        
        Element pdate_child=doc.createElement("pdate");
        root.appendChild(pdate_child);
        Text t1=doc.createTextNode(parameter0);
        pdate_child.appendChild(t1);
        
         Element ddate_child=doc.createElement("ddate");
        root.appendChild(ddate_child);
        Text t2=doc.createTextNode(parameter1);
        ddate_child.appendChild(t2);
        
        
          TransformerFactory factory = TransformerFactory.newInstance();
	  Transformer transformer = factory.newTransformer(); 
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");    
        
        
          StringWriter sw = new StringWriter();
	  StreamResult result = new StreamResult(sw);
	  DOMSource source = new DOMSource(doc);
	  transformer.transform(source, result);
	  String xmlString = sw.toString();

           File file = new File("D:/projects/Netbeans/swift/web/layouts/xmls/home.xml");
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	  bw.write(xmlString);
	  bw.flush();
	  bw.close();
        
    }

}
