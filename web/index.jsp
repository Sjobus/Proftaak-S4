<%@ page import="Pts4.Database.DatabaseConnection" %><%--
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

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
  <div></div>
  <form action="urenReg.jsp" method="get">
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Name">
      <span class="input-group-btn">
        <a href="urenReg.jsp">
          <button class="btn btn-default" type="button">Go!</button>
        </a>
      </span>
    </div>
  </div>
  </div>
  </form>
  </body>
</html>
