package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.database.StaffDAO;
import lv.javaguru.java2.database.jdbc.PaymentDAOImpl;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.Payment;
import lv.javaguru.java2.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svetlana Titova on 18.09.2016.
 */
@Controller
public class AddNewPaymentController {
    private PaymentDAO paymentDAO = new PaymentDAOImpl();
    @Autowired
    @Qualifier("ORM_CustomerDAO")
    private CustomerDAO customerDAO;
    private Customer customer = null;
    @Autowired
    //@Qualifier("ORM_StaffDAO")
    private StaffDAO staffDAO;
    private Staff staff;

   // HttpSession session;
    @RequestMapping(value = "addNewPayment", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) throws DBException {

        ModelAndView model = new ModelAndView("addPayment");
        Payment payment = new Payment();
        String customer_id = request.getParameter("customer_id");
        //String staff_id = request.getParameter("staff_id");
        //String rental_id = request.getParameter("rental_id");
        //String amount = request.getParameter("amount");

        //ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
       // Validator validator = vf.getValidator();

       // validate(payment, validator);
       // payment.setAmount((BigDecimal.valueOf(Long.parseLong(amount))));
        payment.setCustomer_id(Integer.parseInt(customer_id));

        //setPaymentDetails(payment);
        paymentDAO.create(payment);
        model.addObject("newPayment", payment);
        return model;
    }
    @RequestMapping(value = "addNewPayment", method = {RequestMethod.GET})
    public  ModelAndView showForm(HttpServletRequest request)  {

        ModelAndView model = new ModelAndView("addNewPayment");
        Payment payment = new Payment();
        String customer_id = request.getParameter("customer_id");
        payment.setCustomer_id(Integer.parseInt(customer_id));
        payment.setAmount(BigDecimal.valueOf(0.000));

        List<Staff> myStaffList=new ArrayList<Staff>();

        try{
        myStaffList=staffDAO.getAll();
        } catch (DBException ex) {

        }

        //String staff_id = request.getParameter("staff_id");
        //String rental_id = request.getParameter("rental_id");
        //String amount = request.getParameter("amount");


        model.addObject("newEmptyPayment", payment);
        model.addObject("staff_list",myStaffList);
        return model;
    }
    private void setPaymentDetails(Payment payment) {
        //payment.setDescription(params.get("description"));
        payment.setPayment_date(payment.getPayment_date());
       // payment.setAmount(params.get("amount")));
    }
}
