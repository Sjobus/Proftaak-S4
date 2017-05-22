<%@ page import="Pts4.Classes.Project" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sibe
  Date: 20-3-2017
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />--%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />

<html lang="${language}">
    <head>
        <!-- JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

        <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
        <meta name="google-signin-client_id" content="395763735612-foaeca42c7840m6r9s0vsut09o8nc8i0.apps.googleusercontent.com">
        <script src="js/GoogleLogout.js"></script>
        <title>UrenRegistratie | AXI</title>
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
                <li role="presentation"><a href="urenOverzicht.jsp">${view}</a></li>
                <li role="presentation" class="disabled"><a href="#">${hours}</a></li>
                <li role="presentation" class="active"><a onclick="signOut()">${logout}</a></li>
            </ul>
        </div>
        <div class="container">
            <%
                if(null!=request.getAttribute("errorMessage"))
                {
                    %>
                    <div class="alert alert-danger">
                    <% out.println(request.getAttribute("errorMessage")); %>
                    </div>
                    <%
                }
                if(null!=request.getAttribute("confirmMessage"))
                {
                    %>
                    <div class="alert alert-success">
                    <% out.println(request.getAttribute("confirmMessage")); %>
                    </div>
                    <%
                }
            %>
            <form class="form-horizontal" action="TimestampController" method="post">
                <div class="form-group">
                    <fmt:message key="urenReg.label.code" var="code"/>
                    <label class="control-label col-sm-2" for="Project">${code}</label>
                    <div class="col-sm-10">
                        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <%
                            ArrayList<Project> topList = Project.GetTopProjects();
                            ArrayList<Project> bottomList = Project.GetBottomProjects();
                            pageContext.setAttribute("TopProject", topList);
                            pageContext.setAttribute("BottomProject",bottomList);
                        %>
                        <select class="form-control" name="Project" id="Project">
                            <c:forEach items="${TopProject}" var="topcurrent">
                                <option value="${topcurrent.GetID()}"><c:out value="${topcurrent.GetID()}"/></option>
                            </c:forEach>

                            <c:forEach items="${BottomProject}" var="bottomCurrent">
                                <option value="${bottomCurrent.GetID()}"><c:out value="${bottomCurrent.GetID()}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <fmt:message key="urenReg.label.hours" var="hours"/>
                    <label class="control-label col-sm-2" for="Uren">${hours}</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="number" name="Uren" id="Uren" min="1" max="24" placeholder="1" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <fmt:message key="urenReg.label.submit" var="date"/>
                    <label class="control-label col-sm-2" for="Work_Date">${date}</label>
                    <div class="col-sm-10">
                        <div class="input-group date">
                            <input type="text" class="form-control" id="Work_Date" name="Work_Date">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $('.input-group.date').datepicker({
                            format: "dd/mm/yyyy",
                            maxViewModeL: 1,
                            todayBtn: "linked",
                            language: "nl",
                            daysOfWeekDisabled: "0,6",
                            daysOfWeekHighlighted: "0,6",
                            autoclose: true,
                            todayHighlight: true,
                            orientation: "auto"
                        });
                    </script>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <fmt:message key="urenReg.label.submit" var="submit"/>
                        <button type="submit" class="btn btn-default">${submit}</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
