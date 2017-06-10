package Pts4.Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Created by myron on 09-06-17.
 */
public class SearchController extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ImagingOpException, ServletException, IOException
    {
        try
        {
            String searchTerm = request.getParameter("search");
            if (searchTerm != "")
            {
                request.setAttribute("searchTerms", searchTerm);
            }
            RequestDispatcher view = request.getRequestDispatcher("urenOverzichtProject.jsp");
            view.forward(request, response);
        }
        catch (Exception ex)
        {
            System.out.println("Er is een fout op getreden. Error:" + ex.getMessage());
        }
    }
}
