<%-- 
    Document   : forgotpass
    Created on : 4 Oct, 2018, 9:15:24 PM
    Author     : kolip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/logincss.css" rel="stylesheet" type="text/css" media="all">

        <title>JSP Page</title>
    </head>
    <body class="center">
 
        
          <form action="forgotpassserv" method="post" name="forms" onsubmit="return check()">
  <ul class="formstyle">
      <li>
        <label>Mobile Or Email Id</label>
        <input type="text" id="username" name="username" class="formswidth"/>
        <span class="required" id="usernamereq"></span>
      </li>
      <li>
          <label>New Password</label>
          <input type="password" id="pass" name="pass" class="formswidth"/>
          <span class="required" id="lpassreq"></span>
      </li>
      <li>
          <label>Confirm Password</label>
          <input type="password" id="cnpass" name="cnpass" class="formswidth"/>
          <span class="required" id="cnpassreq"></span>
      </li>
      <li>
           <input type="submit" value="Update" />
      </li>
      

  </ul>
         </form>
    
            <script src="layouts/scripts/forgotpassjs.js" type="text/javascript" ></script>

    </body>
</html>
