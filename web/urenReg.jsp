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
        <!-- JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
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

        <form class="form-horizontal" action="TimestampController" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="Project">Project Code:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="Project" id="Project" placeholder="Project code">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="Uren">Uren:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="number" name="Uren" id="Uren" min="1" max="24" placeholder="1" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="Work_Date">Datum:</label>
                <div class="col-sm-10">
                    <div class="input-group date">
                        <input type="text" class="form-control" id="Work_Date">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                    </div>
                </div>
                <script type="text/javascript">
                    $('.input-group.date').datepicker({
                        format: "dd/mm/yyyy",
                        todayBtn: "linked",
                        language: "nl",
                        orientation: "auto",
                        daysOfWeekDisabled: "0,6",
                        daysOfWeekHighlighted: "0,6",
                        autoclose: true,
                        todayHighlight: true
                    });
                </script>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Geef uren op.</button>
                </div>
            </div>
        </form>
    </body>
</html>
