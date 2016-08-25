package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVCFilter implements Filter {

    private static Logger logger = Logger.getLogger(MVCFilter.class.getName());

    private ApplicationContext springContext;

    private Map<String, MVCController> controllerMapping;

    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext =
                    new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }

        controllerMapping = new HashMap<String, MVCController>();
        //controllers = new HashMap<String, MVCController>();
        controllerMapping.put("/index",new HelloWorldController());  //mapping stranici na controller !!!!!!!!!!
        controllerMapping.put("/main", getBean(CustomerListController.class));
        controllerMapping.put("/payments", getBean(PaymentController.class));
       // controllers.put("/*", new HelloWorldController());  //mapping stranici na controller ??!!!!!!!!!!
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();//unikalnij put zaprosa , k kakoj stanice obratilis'
        MVCController controller = controllerMapping.get(contextURI);// naprimer prishlo /hello i mi nahodim ego kontroller
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
