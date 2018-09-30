<%-- 
    Document   : home
    Created on : 30 Jul, 2018, 10:13:11 AM
    Author     : kolip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
              String em=null;
                 Cookie cookiearr[]=request.getCookies();
                 HttpSession sess=request.getSession();
                 
                 for(Cookie cok:cookiearr){
                    if(cok.getName().equals("email")){
                       em=cok.getValue().trim();
                        sess.setAttribute("email", em);
                    }
                }
          %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/homecss.css" rel="stylesheet" type="text/css" media="all">

        <title>JSP Page</title>
   
    </head>
    <body>
      <div class="navbar">
        <div class="navbar">
              <a href="logoutserv">Logout</a>

  <a href="profile.jsp">Profile</a>
  <a href="bookedserv">Booked</a>
  <a href="home.jsp">Home</a>
</div>
      </div>

        <div class="container" >
<div class="card">
    <b><p><%="Welcome Back"+" "+em%></p></b>

    <form  action="homeserv" method="post" onsubmit="return val()">
  <ul class="formstyle">
      <li>
        <label>Pickup</label>
         <select name="pickup" class="formswidth">
          <option>Coimbatore</option>
          <option>Hyderabad</option>
          <option>Kochi</option>
          <option>Chennai</option>
          </select>
        <span class="required" id="cityreq"></span>
      </li>
      <li>
          <label>Pickup Date</label>
          <input type="date" id="pdate" name="pdate" class="formswidth"/>
          <span class="required" id="preq"></span>
          <script type='text/javascript'>
$(document).ready(function(){

 $('#pdate').datepicker({
  dateFormat: "yy-mm-dd",
  maxDate:'+1m +10d',
  minDate: -1

 });

});
</script>
      </li>
      <li>
        <label>Drop off</label>
        <input type="date" id="ddate" name="ddate" class="formswidth"/>
        <span class="required" id="dreq"></span>
        <script type='text/javascript'>
$(document).ready(function(){

 $('#ddate').datepicker({
  dateFormat: "yy-mm-dd",
  maxDate:'+1m +10d',
  minDate: -1

 });

});
</script>
      </li>
      
        <li>
            <br>
            
          <input type="submit" value="Confirm Booking" />
          
      
          
        </li>
  </ul>
      </form>
</div>
            </div>

        <script src="layouts/scripts/homejs.js"></script>
    </body>
</html>
