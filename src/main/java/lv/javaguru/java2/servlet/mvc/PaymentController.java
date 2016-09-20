package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.database.jdbc.PaymentDAOImpl;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */

@Controller
public class PaymentController {
    private PaymentDAO paymentDAO = new PaymentDAOImpl();
    @Autowired
    @Qualifier("ORM_CustomerDAO")
    private CustomerDAO customerDAO;
    private Customer customer = null;
    HttpSession session;

    @RequestMapping(value = "/payments", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) throws DBException {

        ModelAndView model = new ModelAndView("paymentsList");
        String id = request.getParameter("customer_id");
        List<Payment> myList = null;

        session = request.getSession();
        customer = customerDAO.getCustomerById(Integer.parseInt(id));

        try {
            myList = paymentDAO.getAllPaymentByCustId(Integer.parseInt(id));

        } catch (DBException ex) {

        }

        model.addObject("model", myList);
        model.addObject("customerName", customer);
        return model;
    }


}

