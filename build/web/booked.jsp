<%-- 
    Document   : booked
    Created on : 7 Sep, 2018, 10:33:59 AM
    Author     : kolip
--%>

<%@page import="servlets.bookedgetset"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/bookedcss.css" rel="stylesheet" type="text/css" media="all">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="navbar">
              <a href="logoutserv">Logout</a>

  <a href="profile.jsp">Profile</a>
  <a href="bookedserv">Booked</a>
  <a href="home.jsp">Home</a>
</div>
        <div>
        <div class="right-side">
        <div class="card-container">
        <b>Upcoming Bookings</b>
        
        <% ArrayList<bookedgetset> ars= (ArrayList<bookedgetset>)session.getAttribute("upcoming");
            
            for(bookedgetset brs:ars){
             %>
          <div class="card">
              <img class="cars-img" src="<%=brs.getCarimg()%>" width="80px">
        <header>
            <h3><%=brs.getCarname()%></h3>
        </header> 
        <main class="card__description">
            <p><%=brs.getFromdate()%></p>
            <p><%=brs.getTodate()%></p>
        </main>
          </div>
<%} %>
</div>
</div>

</div>
    </body>
</html>
