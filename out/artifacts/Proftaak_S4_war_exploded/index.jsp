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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

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
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation"><a href="index.jsp">Home</a></li>
                <li role="presentation" class="disabled"><a href="#">Uren registratie</a></li>
                <li role="presentation" class="disabled"><a href="#">Overzicht</a></li>
                <li role="presentation" class="disabled"><a href="#">Project Uren</a></li>
                <li role="presentation" class="active"><a href="index.jsp"> Inloggen</a></li>
            </ul>
        </div>
        <div class="container">
            <div class="Fout">
                <h2>
                    <%
                        if(null!=request.getAttribute("errorMessage"))
                        {
                            out.println(request.getAttribute("errorMessage"));
                        }
                    %>
                </h2>
            </div>
            <form action="HomeController" method="post" id="loginForm" class="navbar-form">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" name="tbUserName" class="form-control" placeholder="Name" autofocus/>
                </div>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" name="tbPassword" class="form-control" placeholder="Password"/>
                </div>
                <div class="input-group">
                        <button type="submit" class="btn btn-primary">Login</button>
                </div>
                <input name="googleID" type="hidden" id="googleID" value=""><%--hidden tag--%>
                <input type=hidden id="prGoogleID" name="prGoogleID"> <%--hidden tag--%>
                <div class="g-signin2" data-onsuccess="onSignIn"></div>
            </form>
        </div>
    </body>
</html>
