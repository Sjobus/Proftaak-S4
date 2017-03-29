package Pts4.Controllers;

import Pts4.Classes.Timestamp;
import Pts4.Classes.staticPerson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class HomeController extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ImagingOpException, ServletException, IOException
    {
        String userName = request.getParameter("tbUserName");
        staticPerson sp = new staticPerson();
        try
        {
            if(staticPerson.GetPersonData(userName))
            {
                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
                view.forward(request, response);
            }
            else
            {

            }
//            if (userName == "Jan")
//            {
//                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
//                view.forward(request, response);
//            }
        }
        catch (IOException e)
        {
            System.out.println("Er is een fout op getreden. Error:" + e.getMessage());
        }
    }

}
