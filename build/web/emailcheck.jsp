<%-- 
    Document   : emailcheck
    Created on : 2 Aug, 2018, 12:13:40 AM
    Author     : kolip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
       <%
        String email=request.getParameter("email");
//        String data="";
//        if(email==null){
//        email=" ";
//        }
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/carrental", "root", "hector1998");
PreparedStatement ps=con.prepareStatement("select * from users where email=?");  
ps.setString(1,email);
ResultSet rs=ps.executeQuery();
 
if(rs.next()){  
}else{  
out.print("Email is not regstered ");  
}  
}catch(Exception e){out.print(e);}  
 
%>