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
<%@ page import="Pts4.Classes.WeekBean" %>

<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <li role="presentation"><a href="urenReg.jsp">${regis}</a></li>
                <li role="presentation" class="active"><a href="urenOverzicht.jsp">${view}</a></li>
                <li role="presentation"><a href="urenOverzichtProject.jsp">${hours}</a></li>
                <li role="presentation"><a onclick="signOut()">${logout}</a></li>
            </ul>
        </div>
        <div class="container">
            <%
                Person person = new Person(staticPerson.GetID(), staticPerson.GetName(), staticPerson.GetFunction());
                ArrayList<WeekBean> WeekListPerson = Timestamp.getWeekBeansByPerson(person);
                pageContext.setAttribute("weekList",WeekListPerson);
            %>
            <c:if test="${empty weekList}">
                <div class="alert alert-info">
                    <fmt:message key="info.label.nohours" var="info"/>
                    <label>${info}</label>
                </div>
            </c:if>
            <div class="panel panel-default">

                <fmt:message key="urenOverzicht.label.week" var="week"/>
                <fmt:message key="urenOverzicht.label.date" var="date"/>
                <fmt:message key="urenOverzicht.label.project" var="project"/>
                <fmt:message key="urenOverzicht.label.tm" var="tm"/>
                <fmt:message key="urenOverzicht.label.totaal" var="totaal"/>
                <fmt:message key="urenOverzicht.label.uren" var="totalhours"/>

                <c:forEach items="${weekList}" var="weekEntry">
                    <div class="panel-heading spoiler-trigger" data-toggle="collapse">
                        <div class="row">
                            <div class="col-xs-3">
                                ${week} <c:out value="${weekEntry.getWeek()}"/>
                            </div>
                            <div class="col-xs-6">
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${weekEntry.getFirstday()}" />
                                 ${tm}
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${weekEntry.getLastday()}" />
                            </div>
                            <div class="col-xs-3">
                                ${totaal} <c:out value="${weekEntry.getHours()}"/>
                            </div>
                        </div>
                    </div>
                    <div class="panel-collapse collapse out">
                        <div class="panel-body">
                            <ul class="list-group">
                                <c:forEach items="${weekEntry.getTimestamps()}" var="timeEntry">
                                    <a href="#" class="list-group-item">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                ${date} <fmt:formatDate pattern = "dd-MM-yyyy" value = "${timeEntry.GetDate()}" />
                                            </div>
                                            <div class="col-xs-6">
                                                ${project} <c:out value="${timeEntry.Getproject().GetID()}"/>
                                            </div>
                                            <div class="col-xs-3">
                                                    ${totalhours} <c:out value="${timeEntry.GetHour()}"/>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
