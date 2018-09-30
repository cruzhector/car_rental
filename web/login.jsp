<%-- 
    Document   : login
    Created on : 29 Jul, 2018, 8:31:16 PM
    Author     : kolip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<%
                             Cookie cookiearr[]=request.getCookies();
                             if(cookiearr!=null){
 for(Cookie cok:cookiearr){
                    if(cok.getName().equals("email")){
                        response.sendRedirect("home.jsp");
                    }
                }
                             }
                               
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/logincss.css" rel="stylesheet" type="text/css" media="all">

        <title>JSP Page</title>
    </head>
    <body class="center">
 
          <span class="required">${mess}</span>
        
        <form action="loginserv" method="post" name="forms" onsubmit="sendInfo()">
  <ul class="formstyle">
      <li>
        <label>Mobile Or Email Id</label>
        <input type="text" id="username" name="username" class="formswidth"/>
        <span class="required" id="usernamereq"></span>
      </li>
      <li>
          <label>Password</label>
          <input type="password" id="pass" name="pass" class="formswidth"/>
          <span class="required" id="lpassreq"></span>
      </li>
       <li>
           <input type="submit" value="Log In" />
      </li>
      <span><p> Not a User ?<a href="signup.jsp"> Register</a></p></span>
  </ul>
         </form>
    
            <script src="layouts/scripts/loginajax.js" type="text/javascript" ></script>

    </body>
</html>
