package lv.javaguru.java2.servlet.mvc.spring;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Svetlana Titova on 29.08.2016.
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();


        session.setAttribute("customer_id",  1);
        //  session.setAttribute("access_level", AccessLevel.GUEST.getValue());
       // session.setAttribute("liked", new ArrayList<Long>());

        System.out.println("Session Created:: ID=" + sessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("Session Destroyed:: ID=" + sessionEvent.getSession().getId());
    }
}