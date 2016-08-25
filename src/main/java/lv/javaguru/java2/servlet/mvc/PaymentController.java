package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.database.jdbc.PaymentDAOImpl;
import lv.javaguru.java2.domain.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
@Controller
@RequestMapping("/payments")
public class PaymentController implements MVCController
{
    private PaymentDAO paymentDAO = new PaymentDAOImpl();

   // @RequestMapping(value = "customer_id", method = RequestMethod.GET)

    public MVCModel execute(HttpServletRequest request) throws DBException {

        //request.setAttribute("name", "John");
        String id = request.getParameter("customer_id");
        List<Payment> myList = paymentDAO.getAllPaymentByCustId(Integer.parseInt(id));
        return new MVCModel(myList, "/paymentsList.jsp");
    }

}

