<%--
  Created by IntelliJ IDEA.
  User: Sibe
  Date: 2-4-2017
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/js/jquery-3.2.0.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script>
        $(document).ready(function(){
        $(".spoiler-trigger").click(function()
        {
            $(this).parent().next().collapse('toggle');
        });
        });
    </script>
    <title>AXI</title>
</head>
<body>
    <div>
        <ul class="nav nav-tabs nav-justified">
            <li role="presentation"><a href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a> </li>
            <li role="presentation"><a href="urenReg.jsp">Uren registratie</a> </li>
            <li role="presentation" class="active"><a href="Persoon_Overzicht.jsp">Overzicht</a></li>
            <li role="presentation" class="disabled"><a href="#">Project Uren</a></li>
            <li role="presentation" class="disabled"><a href="index.jsp"> Uitloggen</a> </li>
        </ul>
    </div>

    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <button type="button" class="btn btn-default btn-xs spoiler-trigger" data-toggle="collapse">
                    Week 13  22-03 t/m 29-03 Totaal aantal uren: 24
                </button>
            </div>
            <div class="panel-collapse collapse out">
                <div class="panel-body">
                    <ul class="list-group">
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
    <br>
    <ul class="media">
        <li class="media">
            <div class="media-body">
                <h4 class="media-heading">Week 13  22-03 t/m 29-03 Totaal aantal uren: 24</h4>
                <div class="list-group">
                    <a href="#" class="list-group-item">22-03-2017  Project: PTS41  Uren: 5</a>
                    <a href="#" class="list-group-item">22-03-2017  Project: PTS32  Uren: 3</a>
                    <a href="#" class="list-group-item">23-03-2017  Project: S42T   Uren: 8</a>
                    <a href="#" class="list-group-item">24-03-2017  Project: S42T   Uren: 5</a>
                    <a href="#" class="list-group-item">25-03-2017  Project: S42T   Uren: 3</a>
                </div>
            </div>
        </li>
    </ul>
</body>
</html>
