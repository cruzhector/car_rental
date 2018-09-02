/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class bookingserv extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, TransformerException, ParserConfigurationException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet bookingserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bookingserv at " + request.getContextPath() + "</h1>");
            
            Connection connec=connection.con();
            out.println("success");
            HttpSession session=request.getSession();
            PreparedStatement ps=connec.prepareStatement("INSERT INTO booking(email,carname,city,fromdate,todate) VALUES(?,?,?,?,?)");
            ps.setString(1, (String) session.getAttribute("email"));
            ps.setString(2, request.getParameter("carname"));
            ps.setString(3,(String)session.getAttribute("city"));
            ps.setString(4,(String)session.getAttribute("from"));
            ps.setString(5,(String)session.getAttribute("to"));
            ps.executeUpdate();
            response.sendRedirect("home.jsp");
              DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		  DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
		  //creating a new instance of a DOM to build a DOM tree.
		  Document doc = docBuilder.newDocument();
		  new bookingserv().createXmlTree(doc,(String) session.getAttribute("email"), request.getParameter("carname"),(String)session.getAttribute("city"),(String)session.getAttribute("from"),(String)session.getAttribute("to"));
              
            if(ps!=null){
                ps.close();
            }
                if(connec!=null){
                connec.close();
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(bookingserv.class.getName()).log(Level.SEVERE, null, ex);
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

    public void createXmlTree(Document doc, String string, String parameter, String string0, String string1, String string2)throws TransformerConfigurationException, TransformerException, FileNotFoundException, IOException{  
     Element root=doc.createElement("ns:booking");
        doc.appendChild(root);
        
        Element email_child=doc.createElement("ns:email");
        root.appendChild(email_child);
        Text t=doc.createTextNode(string);
        email_child.appendChild(t);
        
        Element car_child=doc.createElement("ns:carname");
        root.appendChild(car_child);
        Text t1=doc.createTextNode(parameter);
        car_child.appendChild(t1);
        
         Element city_child=doc.createElement("ns:city");
        root.appendChild(city_child);
        Text t2=doc.createTextNode(string0);
        city_child.appendChild(t2);
        
          
        Element from_child=doc.createElement("ns:from");
        root.appendChild(from_child);
        Text t3=doc.createTextNode(string1);
        from_child.appendChild(t3);
        
         Element to_child=doc.createElement("ns:to");
        root.appendChild(to_child);
        Text t4=doc.createTextNode(string2);
        to_child.appendChild(t4);
        
         TransformerFactory factory = TransformerFactory.newInstance();
	  Transformer transformer = factory.newTransformer(); 
	  transformer.setOutputProperty(OutputKeys.INDENT, "yes");    
        
        
          StringWriter sw = new StringWriter();
	  StreamResult result = new StreamResult(sw);
	  DOMSource source = new DOMSource(doc);
	  transformer.transform(source, result);
	  String xmlString = sw.toString();

           File file = new File("D:/projects/Netbeans/swift/web/layouts/xmls/booking.xml");
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	  bw.write(xmlString);
	  bw.flush();
	  bw.close();
        
    }

}
