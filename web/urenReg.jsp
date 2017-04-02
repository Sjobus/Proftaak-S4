<%--
  Created by IntelliJ IDEA.
  User: Sibe
  Date: 20-3-2017
  Time: 13:14
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
            <li role="presentation" class="active"><a href="urenReg.jsp">Uren registratie</a> </li>
            <li role="presentation" class="disabled"><a href="#">Overzicht</a></li>
            <li role="presentation" class="disabled"><a href="#">Project Uren</a></li>
            <li role="presentation"><a href="index.jsp"> Uitloggen</a> </li>
        </ul>
    </div>
    <form method="post">
        Project Code:<br>
        <input type="text" name="Project" placeholder="Project code"><br>
        Uren:<br>
        <input type="number" name="Uren" min="1" max="24" placeholder="1"><br>
        Datum:<br>
        <input type="date" name="Work_Date" min="2017-01-01"><br>
        <button type="submit">Geef uren op.</button>
    </form>
</body>
</html>
