package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;


    public void init(FilterConfig filterConfig) throws ServletException {
        controllers = new HashMap<String, MVCController>();
        controllers.put("/index",new HelloWorldController());  //mapping stranici na controller !!!!!!!!!!
        controllers.put("/main",new CustomerListController());
        controllers.put("/*", new HelloWorldController());  //mapping stranici na controller !!!!!!!!!!
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();//unikalnij put zaprosa , k kakoj stanice obratilis'
        MVCController controller = controllers.get(contextURI);// naprimer prishlo /hello i mi nahodim ego kontroller
        if (controller != null) {
            MVCModel model = null;
            try {
                model = controller.execute(req);
            } catch (DBException e) {
                e.printStackTrace();
            }

            req.setAttribute("model", model.getData());// zdes dannie dlja prorisovki UI komponenta

            ServletContext context = req.getServletContext();// vse jsp moego prilozhenija
            RequestDispatcher requestDispacher =
                    context.getRequestDispatcher(model.getViewName()); // nazvanie jsp kuda perejti
            requestDispacher.forward(req, resp);
        }
        else filterChain.doFilter(request,response);
    }

    public void destroy() {

    }

}
