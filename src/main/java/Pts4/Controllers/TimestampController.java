package Pts4.Controllers;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Classes.Timestamp;
import Pts4.Classes.staticPerson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gebruiker on 2-4-2017.
 */
public class TimestampController extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ImagingOpException, ServletException, IOException
    {

        String hourStr = request.getParameter("Uren");
        String dateStr = request.getParameter("Work_Date"); //moet geconvert worden naar date
        String projectID = request.getParameter("Project");

        System.out.println("========================================");
        System.out.println("Uren: " + hourStr + " Datum: " + dateStr + " Project: " + projectID);
        System.out.println("========================================");

        Project pro = new Project(projectID);
        pro.Getproject();

        Person per = new Person(staticPerson.GetID(), staticPerson.GetName(), staticPerson.GetFunction());

//        String dateStr = "22/12/2017";
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        int Hour = 1;
        try
        {
            Hour = Integer.parseInt(hourStr);
            date = dateformat.parse(dateStr);
        }
        catch (ParseException e)
        {
            System.out.println("Er is een Parse fout op getreden. Error:" + e.getMessage());
            e.printStackTrace();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Er is een Format fout op getreden. Error:" + e.getMessage());
        }
        Timestamp time = new Timestamp(Hour, date , pro, per);
        try
        {
            if(time.InsertTimestamp())
            {
                request.setAttribute("confirmMessage", "Opdracht opgeslagen");
                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
                view.forward(request, response);
            }
            else
            {
                request.setAttribute("errorMessage", "Niet alles goed ingevuld");
                RequestDispatcher rd = request.getRequestDispatcher("urenReg.jsp");
                rd.forward(request, response);
            }
        }
        catch (Exception e)
        {
            System.out.println("Er is een fout op getreden. Error:" + e.getMessage());
        }
    }
}
