<%--
  Created by IntelliJ IDEA.
  User: Sibe
  Date: 2-4-2017
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="Pts4.Classes.Timestamp" %>
<%@ page import="Pts4.Classes.staticPerson" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Pts4.Classes.Person" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="/js/jquery-3.2.0.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
        <meta name="google-signin-client_id" content="395763735612-foaeca42c7840m6r9s0vsut09o8nc8i0.apps.googleusercontent.com">
        <script src="js/GoogleLogout.js"></script>
        <script src="js/Spoiler.js"></script>
        <title>UrenOverzicht | AXI</title>
    </head>
    <body>
        <div>
            <fmt:message key="navBar.label.home" var="home"/>
            <fmt:message key="navBar.label.registration" var="regis"/>
            <fmt:message key="navBar.label.view" var="view"/>
            <fmt:message key="navBar.label.projecthours" var="hours"/>
            <fmt:message key="navBar.label.logout" var="logout"/>
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation"><a href="index.jsp">${home}</a></li>
                <li role="presentation"><a href="urenReg.jsp">${regis}</a> </li>
                <li role="presentation" class="active"><a href="urenOverzicht.jsp">${view}</a></li>
                <li role="presentation" class="disabled"><a href="#">${hours}</a></li>
                <li role="presentation"><a onclick="signOut()"> ${logout}</a></li>
            </ul>
        </div>
        <div class="container">
            <%
                Person person = new Person(staticPerson.GetID(), staticPerson.GetName(), staticPerson.GetFunction());
                ArrayList<Timestamp> TimeListPerson = Timestamp.GetTimestampsByProject(person);
                pageContext.setAttribute("timeList",TimeListPerson);
            %>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <button type="button" class="btn btn-default btn-xs spoiler-trigger" data-toggle="collapse">
                        Week 13  22-03 t/m 29-03 Totaal aantal uren: 24
                    </button>
                </div>
                <div class="panel-collapse collapse out">
                    <div class="panel-body">
                        <ul class="list-group">
                            <c:forEach items="${timeList}" var="timeEntry">
                                <a href="#" class="list-group-item">
                                    Date: <c:out value="${timeEntry.GetDate()}"/>
                                    Project: <c:out value="${timeEntry.Getproject().GetID()}"/>
                                    Uren: <c:out value="${timeEntry.GetHour()}"/>
                                </a>
                            </c:forEach>
                            <a href="#" class="list-group-item">22-03-2017  Project: PTS41  Uren: 5</a>
                            <a href="#" class="list-group-item">22-03-2017  Project: PTS32  Uren: 3</a>
                            <a href="#" class="list-group-item">23-03-2017  Project: S42T   Uren: 8</a>
                            <a href="#" class="list-group-item">24-03-2017  Project: S42T   Uren: 5</a>
                            <a href="#" class="list-group-item">25-03-2017  Project: S42T   Uren: 3</a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
