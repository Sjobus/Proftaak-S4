package Pts4.Controllers;
import Pts4.Classes.staticPerson;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("tbUserName");
        //staticPerson sp = new staticPerson();
        try
        {
            //if(sp.GetPersonData(userName))
        //{
           // RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
           // view.forward(request, response);
        //}
            if (userName.equals("Jan"))
            {
                RequestDispatcher view = request.getRequestDispatcher("urenReg.jsp");
                view.forward(request, response);
            }
        }
        catch (IOException e)
        {
            System.out.println("Er is een fout op getreden. Error:" + e.getMessage());
        }
    }
}
