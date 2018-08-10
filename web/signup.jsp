<%-- 
    Document   : signup
    Created on : 29 Jul, 2018, 8:32:05 PM
    Author     : kolip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="layouts/styles/signupcss.css" rel="stylesheet" type="text/css" media="all">

        <title>JSP Page</title>
    </head>
    <body>


  <div class="topnav">
    <div class="topnav-left">
      <a href="#home">SWIFT</a>

    </div>

    <div class="topnav-right">

   
      <a href=""><img src="user.png" width="15" height="15" ></a>

    </div>
  </div>

<div class="card2">
    <form action="signupserv" method="post" onsubmit="return val()">
  <ul class="formstyle">
      <li>
        <label>Full Name</label>
        <input type="text" id="name" name="name" class="formswidth"/>
        <span class="required" id="namereq"></span>
      </li>
      <li>
          <label>Email </label>
          <input type="email" id="email" name="email" class="formswidth"/>
          <span class="required" id="emailreq"></span>
      </li>
      <li>
        <label>Phone Number</label>
        <input type="text" id="phnnum" name="phnnum" class="formswidth"/>
        <span class="required" id="phnreq"></span>
      </li>
      <li>
        <label>D.O.B</label>
        <input type="date" id="dob" name="dob" class="formswidth" />
        <span class="required" id="dobreq"></span>
      </li>
      <li>
          <label>Gender</label>
          <select name="gender" class="formswidth">
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          </select>
      </li>
      <li>
        <label>Password</label>
        <input type="password" id="password" name="pass" class="formswidth" />
        <span class="required" id="passreq"></span>
      </li>
      <li>
        <label>Confirm Password </label>
        <input type="password" id="confrmpass" name="cnfrmpass" class="formswidth"  />
        <span class="required" id="cpassreq"></span>
      </li>
      <li>
        <label>Driving License</label>
        <input type="text" id="license" name="license" class="formswidth" />
        <span class="required" id="lisreq"></span>
      </li>
      <li>
        <label>Aadhar Number </label>
        <input type="text" id="aadhar" name="aadhar" class="formswidth"  />
        <span class="required" id="aadarreq"></span>
      </li>
      <li>
          <input type="submit" value="Sign Up" />
      </li>
  </ul>
  </form>
  </div>
        <script src="layouts/scripts/signupjs.js" type="text/javascript" ></script>
   
        
</body>
</html>
