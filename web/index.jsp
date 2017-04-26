<%--
=======
<%@ page import="Pts4.Database.DatabaseConnection" %><%--
>>>>>>> refs/remotes/origin/Sprint1
  Created by IntelliJ IDEA.
  User: Sibe
  Date: 13-3-2017
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
      <script src="https://apis.google.com/js/platform.js" async defer></script>
      <meta name="google-signin-client_id" content="395763735612-foaeca42c7840m6r9s0vsut09o8nc8i0.apps.googleusercontent.com">

      <title>AXI</title>
  </head>
  <body>
  <div>
    <ul class="nav nav-tabs nav-justified">
      <li role="presentation"><a href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a> </li>
      <li role="presentation" class="disabled"><a href="urenReg.jsp">Uren registratie</a> </li>
      <li role="presentation" class="disabled"><a href="#">Overzicht</a></li>
      <li role="presentation" class="disabled"><a href="#">Project Uren</a></li>
      <li role="presentation" class="disabled"><a href="index.jsp"> Uitloggen</a> </li>
    </ul>
  </div>
  <br />
  <div class="Fout"><h2>
      <%
      if(null!=request.getAttribute("errorMessage"))
      {
          out.println(request.getAttribute("errorMessage"));
      }
      %>
      <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
      <c:set var="val" value="5"/>
      <c:choose>
          <c:when test="${val == '5'}">
              Value is 5
          </c:when>
          <c:otherwise>
              Value is not 5
          </c:otherwise>
      </c:choose>
  </h2></div>

      <div class="g-signin2" data-onsuccess="onSignIn"></div>

  <script>
      function onSignIn(googleUser) {
          // Useful data for your client-side scripts:
          var profile = googleUser.getBasicProfile();
          console.log("ID: " + profile.getId()); // Don't send this directly to your server!
          console.log('Full Name: ' + profile.getName());
          console.log('Given Name: ' + profile.getGivenName());
          console.log('Family Name: ' + profile.getFamilyName());
          console.log("Image URL: " + profile.getImageUrl());
          console.log("Email: " + profile.getEmail()); }

      function signOut() {
          var auth2 = gapi.auth2.getAuthInstance();
          auth2.signOut().then(function() {
              console.log('User signed out.'); } )}

  </script>


      <form action="HomeController" method="post">
      <div class="col-lg-6">
          <div class="input-group">
              <input type="text" name="tbUserName" class="form-control" placeholder="Name"/>
              <input type="password" name="tbPassword" class="form-control" placeholder="Password"/>
              <span class="input-group-btn">
                  <button type="submit" class="btn btn-default">Login</button>
              </span>
          </div>
      </div>
  </form>
  </body>
</html>
