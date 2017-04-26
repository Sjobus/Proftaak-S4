package Pts4.Controllers;

import Pts4.Classes.staticPerson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class HomeController extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ImagingOpException, ServletException, IOException
    {
        String userName = request.getParameter("tbUserName");
        try
        {
            PrintWriter out = response.getWriter();
            if(staticPerson.GetPersonData(userName))
            {
                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
                view.forward(request, response);
            }
            else
            {
                  request.setAttribute("errorMessage", "Invalid user or password");
                  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                  rd.forward(request, response);
//                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//                view.forward(request, response);
            }
        }
        catch (Exception e)
        {
            System.out.println("Er is een fout op getreden. Error:" + e.getMessage());
        }
    }

}
