package lv.javaguru.java2.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/index")
public class RedirectToJSPServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // Prepare output html
        ServletContext servletContext = getServletContext();

        request.setAttribute("name", "John");
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/helloWorld.jsp");

        requestDispatcher.forward(request, response);
    }

}