package Pts4.Controllers;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Classes.staticPerson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Created by Gebruiker on 2-4-2017.
 */
public class TimestampController extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ImagingOpException, ServletException, IOException
    {

        int Hour = Integer.parseInt(request.getParameter("Uren"));

        String dateStr = request.getParameter("Work_Date"); //moet geconvert worden naar date

        String projectID = request.getParameter("");
        Project pro = new Project(projectID);
        pro.Getproject();

        Person per = new Person(staticPerson.GetID(), staticPerson.GetName(), staticPerson.GetFunction());

//        Timestamp time = new Timestamp(Hour, /*date goes here*/ , pro, per);
//
//        try
//        {
//            if(time.InsertTimestamp())
//            {
//                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
//                view.forward(request, response);
//            }
//            else
//            {
//                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
//                view.forward(request, response);
//            }
//        }
//        catch (Exception e)
//        {
//            System.out.println("Er is een fout op getreden. Error:" + e.getMessage());
//        }
    }





}
