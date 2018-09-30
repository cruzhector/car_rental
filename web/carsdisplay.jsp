<%-- 
    Document   : carsdisplay
    Created on : 3 Aug, 2018, 11:37:07 AM
    Author     : kolip
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="servlets.carsgetset"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="getsets.homegetset"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/carsdisplaycss.css" rel="stylesheet" type="text/css" media="all">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="navbar">
              <a href="logoutserv">Logout</a>

  <a href="profile.jsp">Profile</a>
  <a href="bookedserv">Booked</a>
  <a href="home.jsp">Home</a>
</div>
<div class="left-side">
    
    <h3 style="color: darkgray">Location</h3>
     <div class="card2">
         <p style="color: #BEBEBE;padding:2px 10px; text-align: left; font-size: 10px;">Your Starting Point</p>
         <p style="padding-bottom: 10px; padding-left: 10px; text-align: left; font-size: 15px;"><%out.println((String)session.getAttribute("city"));%></p>
         
     </div>

 <h3 style="color: darkgray">Selected Dates For Your Trip</h3>
     <div class="card2">
         <table class="tables">
             <tr>
                 
                 <td><%out.println((String)session.getAttribute("from"));%></td>
                 <td><%out.println((String)session.getAttribute("to"));%></td>
             </tr>
             
         </table>         
     </div>

</div>
        
<div class="right-side">        
<div class="card-container">
    
            <% ArrayList<carsgetset> ars= (ArrayList<carsgetset>)session.getAttribute("carlist");
            
            for(carsgetset crs:ars){
             %>
             
        <div class="card">
        <img class="cars-img" src="<%=crs.getImg()%>" width="80px">
        <header>
            <h3><%=crs.getCarname()%></h3>
        </header> 
        <main class="card__description">
            <p><%=crs.getCartype()%></p>
            <p><b><%=String.valueOf("Rs."+crs.getCost())%></b></p>
        </main>
        <a href="checkout.jsp?img=<%=crs.getImg()%>&carname=<%=crs.getCarname()%>&cost=<%=String.valueOf("Rs."+crs.getCost())%>" class="button" >Book Now</a>

    </div>
    <%} %>
<!--     <div class="card">
        <img class="cars-img" src="layouts/images/figo.png" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
    
     <div class="card">
        <img class="cars-img" src="layouts/images/rapid.jpg" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
    
    
     <div class="card">
        <img class="cars-img" src="layouts/images/verna.jpg" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
    
     <div class="card">
        <img class="cars-img" src="layouts/images/dzire.png" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
     <div class="card">
        <img class="cars-img" src="layouts/images/innova.jpg" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
    
     <div class="card">
        <img class="cars-img" src="layouts/images/ecosport.jpg" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
    
    
     <div class="card">
        <img class="cars-img" src="layouts/images/ertiga.jpg" width="80px">
        <header>
            <h3>Hyundai i20</h3>
        </header> 
        <main class="card__description">
            <p>5 seater | Manual | 3 bags</p> 
        </main>
        <a href="#" class="button">Book Now</a>

    </div>
    
    
    -->

</div>
</div>
    </body>
</html>
