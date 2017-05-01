package main.java.Pts4.Controllers;

import main.java.Pts4.Classes.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sibe on 1-5-2017.
 */

@WebServlet
public class GetDbData extends HttpServlet
{



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<String> projectList = Project.GetTopProjects();
        request.setAttribute("Code",projectList);
        request.getRequestDispatcher("web/urenReg.jsp").forward(request,response);

    }
}
