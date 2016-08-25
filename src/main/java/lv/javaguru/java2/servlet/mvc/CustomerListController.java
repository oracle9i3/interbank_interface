package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Svetlana Titova on 17.08.2016.
 */
@Controller
public class CustomerListController implements MVCController{
    @Autowired
    private CustomerDAO customerDAO ;//= new CustomerDAOImpl();
    @Autowired
    private PaymentDAO paymentDAO;


    public MVCModel execute(HttpServletRequest request) throws DBException {

        List<Customer> myList = customerDAO.getAll();
        paymentDAO.getAllPaymentByCustId(123);
        return new MVCModel(myList, "/customerList.jsp");
         }
    }
