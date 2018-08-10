<%-- 
    Document   : checkout
    Created on : 9 Aug, 2018, 10:50:30 PM
    Author     : kolip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/checkoutcss.css" rel="stylesheet" type="text/css" media="all">
        
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String x= request.getParameter("cost");
        StringBuilder sb=new StringBuilder();
        sb.append("Pay").append(x);
        String tot=sb.toString();
        %>
        <div class="navbar">
  <a href="profile.jsp">Profile</a>
  <a href="">Contact</a>
  <a href="">Home</a>
</div>
        
        <div class="main">
       <div class="card">
           <center><img src=<%=request.getParameter("img")%> alt="Avatar" width="150px" height="120px"></center>
  <div class="container">
    <h4><%=request.getParameter("carname")%></h4>
    <p><%out.println((String)session.getAttribute("from"));%> to <%out.println((String)session.getAttribute("to"));%></p>
    <p><%out.println((String)session.getAttribute("city"));%></p>
    <p><%=request.getParameter("cost")%></p>
    
  </div>
       </div> 
            <div class="card2">
                <form action="bookingserv" method="post" onsubmit="return valid()">
                    <ul class="formstyle">
       
                        <input type="hidden" name="carname" value=<%=request.getParameter("carname")%>  />
      
      <li>
        <label>Card Number</label>
        <input type="text" id="num" name="num"  class="formswidth" />
        <span class="required" id="numreq"></span>
      </li>
      
      <div class="side">     
          <li id="left" style="margin-right: 70px;">
          <label>Exp Date </label>
          <input type="text" id="expdate" name="expdate" class="formswidth" />
          <span class="required" id="expreq"></span>
      </li>
      
      <li id="right">
          <label>CVV or CVC</label>
          <input type="text" id="cvv" name="cvv" class="formswidth" />
          <span class="required" id="cvvreq"></span>
      </li>
      </div>
       <li>
        <label>Card Holder</label>
        <input type="text" id="holder" name="holder"  class="formswidth" />
        <span class="required" id="holderreq"></span>
      </li>
      <li>
          <input type="submit" value=<%=tot%> />
      </li>
                    </ul>
  </form>
            </div>
        </div>
       
    </body>
</html>
