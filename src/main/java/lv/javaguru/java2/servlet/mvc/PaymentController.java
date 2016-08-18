package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.database.jdbc.PaymentDAOImpl;
import lv.javaguru.java2.domain.Payment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
public class PaymentController implements MVCController{
    private PaymentDAO paymentDAO = new PaymentDAOImpl() ;

    public MVCModel execute(HttpServletRequest request) throws DBException {
        int payment_id   = (int)request.getAttribute("model");
        List<Payment> myList = paymentDAO.getAllPaymentByCustId(payment_id );
        return new MVCModel(myList, "/paymentsList.jsp");
    }
}

