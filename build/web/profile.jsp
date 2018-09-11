<%-- 
    Document   : profile
    Created on : 1 Aug, 2018, 12:50:26 AM
    Author     : kolip
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="servlets.usersgetset"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/profilecss.css" rel="stylesheet" type="text/css" media="all">

        <title>JSP Page</title>
    </head>
<body>
<%
 
            String email=(String)session.getAttribute("email");
        String url="jdbc:mysql://localhost/carrental";
	String user="root";
	String password="hector1998";
	Connection con=null;
        PreparedStatement ps=null;
        ArrayList<usersgetset> arr=new ArrayList<>();

try {
                
		con=(Connection)DriverManager.getConnection(url, user, password);
                ps=con.prepareStatement("SELECT * FROM users WHERE email=?");
                ps.setString(1,email);
                
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    arr.add(new usersgetset(rs.getString("name"),rs.getString("phonenum"),rs.getString("dob"),rs.getString("gender"),rs.getString("license"),rs.getString("aadhar")));
                }
               
                //response.sendRedirect("index.html");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>


    <div class="navbar">
  <a href="profile.jsp">Profile</a>
  <a href="">Contact</a>
  <a href="">Home</a>
</div>
<div class="main">
<div class="card">
    <center><img src="layouts/images/user.png" alt="Avatar">
  <div class="container">
    <h4><%=arr.get(0).getName()%></h4>
    <p><%=arr.get(0).getPhnum()%></p>
    <p><%=(String)session.getAttribute("email")%></p>

  </div>
</center>
</div>
<div class="card2">
  <form action="profupdserv" method="post">
  <ul class="formstyle">
       
             
      
      <li>
        <label>Full Name</label>
        <input type="text" id="name" name="name"  class="formswidth" value="<%=arr.get(0).getName()%>"/>
        <span class="required" id="namereq"></span>
      </li>
      <li>
          <label>Email </label>
          <input type="email" name="email" class="formswidth" value="<%=(String)session.getAttribute("email")%>"/>
          <span class="required" id="emailreq"></span>
      </li>
      <li>
        <label>Phone Number</label>
        <input type="text" id="phnnum" name="phnnum" class="formswidth"  value="<%=arr.get(0).getPhnum()%>"/>
        <span class="required" id="phnreq"></span>
      </li>
      <li>
        <label>D.O.B</label>
        <input type="text" id="dob" class="formswidth" name="dob" value="<%=arr.get(0).getDob()%>"/>
        <span class="required" id="dobreq"></span>
      </li>
      <li>
          <label>Gender</label>
          <select name="gender" class="formswidth">
              <option value="<%=arr.get(0).getGender()%>"><%=arr.get(0).getGender()%></option>
          
          </select>
      </li>
      <li>
        <label>Driving License</label>
        <input type="text" id="license" class="formswidth" name="license" value="<%=arr.get(0).getLicense()%>"/>
        <span class="required" id="lisreq"></span>
      </li>
      <li>
        <label>Aadhar Number </label>
        <input type="text" id="aadhar" class="formswidth" name="aadhar" value="<%=arr.get(0).getAadhar()%>"/>
        <span class="required" id="aadarreq"></span>
      </li>
      <li>
          <input type="submit" value="Update" onsubmit="return validate()"/>
      </li>
  </ul>

  </form>
  </div>

</div>
</body>
</html>
