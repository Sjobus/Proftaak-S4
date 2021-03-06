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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Language Select + flags-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/0.8.2/css/flag-icon.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
        <meta name="google-signin-client_id" content="395763735612-foaeca42c7840m6r9s0vsut09o8nc8i0.apps.googleusercontent.com">
        <script src="js/GoogleLogin.js"></script>
        <script src="js/GoogleLogout.js"></script>
        <title>AXI</title>
    </head>
    <body>
        <div>
            <fmt:message key="navBar.label.home" var="home"/>
            <fmt:message key="navBar.label.registration" var="regis"/>
            <fmt:message key="navBar.label.view" var="view"/>
            <fmt:message key="navBar.label.projecthours" var="hours"/>
            <fmt:message key="navBar.label.login" var="login"/>

            <ul class="nav nav-tabs nav-justified">
                <li role="presentation"><a href="index.jsp">${home}</a></li>
                <li role="presentation" class="disabled"><a href="#">${regis}</a></li>
                <li role="presentation" class="disabled"><a href="#">${view}</a></li>
                <li role="presentation" class="disabled"><a href="#">${hours}</a></li>
                <li role="presentation" class="active"><a href="index.jsp">${login}</a></li>
            </ul>
        </div>
        <div class="container">
            <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info" >
                    <div class="panel-heading">
                        <fmt:message key="index.button.submit" var="buttonValue" />
                        <div class="panel-title">${buttonValue}</div>
                    </div>

                    <div style="padding-top:30px" class="panel-body" >
                        <%--<LANGUAGE IS NL/EN>--%>
                        <c:if test="${not empty errorMessage}" >
                            <div class="alert alert-danger">
                                    <%--//hier message--%>
                                <fmt:message key="index.label.error" var="error"/>
                                <label>${error}</label>
                            </div>
                        </c:if>
                        <form class="form-horizontal" role="form">
                            <div class="input-group margin-bottom">
                                <fmt:message key="index.label.dropKeuze" var="taalKeuze" />
                                <%--<label for="language" id="languageKeuze">${taalKeuze}</label>--%>
                                <span class="input-group-addon"><i class="flag-icon flag-icon-${language == '' ? 'gb' : language == 'en' ? 'gb' : 'nl'}"></i></span>
                                <select class="form-control" id="language" name="language" onchange="submit()">
                                    <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                                    <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                                </select>
                            </div>
                        </form>

                        <form action="HomeController" method="post" id="loginForm" class="form-horizontal" role="form">
                                <div class="input-group margin-bottom">

                                    <%--<label for="tbUserName"><fmt:message key="index.label.username"/>:</label>--%>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                                    <fmt:message key="index.label.username" var="userInput"/>
                                    <input type="text" id="tbUserName" name="tbUserName" class="form-control" placeholder="${userInput}" autofocus required/>

                                </div>
                                <div class="input-group margin-bottom">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                                    <fmt:message key="index.label.password" var="passInput"/>
                                    <input type="password" id="tbPassword" name="tbPassword" class="form-control" placeholder="${passInput}" required/>
                                </div>

                            <div class="input-group margin-bottom">
                                <fmt:message key="index.button.submit" var="buttonValue" />

                                <input type="submit" class="btn btn-primary" value="${buttonValue}">
                                <%--<button type="submit" class="btn btn-primary" value="${buttonValue}" />--%>
                            </div>
                            <hr>
                            <div class="input-group">
                                <input name="googleID" type="hidden" id="googleID" value=""><%--hidden tag--%>
                                <input type=hidden id="prGoogleID" name="prGoogleID"> <%--hidden tag--%>
                                <div class="g-signin2" data-onsuccess="onSignIn"></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
