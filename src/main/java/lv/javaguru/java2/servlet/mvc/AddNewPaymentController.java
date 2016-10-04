package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.database.jdbc.PaymentDAOImpl;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.Payment;
import lv.javaguru.java2.domain.Rental;
import lv.javaguru.java2.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static lv.javaguru.java2.domain.Payment.validate;

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

    @Autowired
    private RentalDAO rentalDAO;
    private Rental rental;

   // @Autowired
   //private SessionFactory sessionFactory;
    HttpSession session;

    @Transactional
  @RequestMapping(value = "addNewPayment", method = {RequestMethod.POST})
   public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) throws DBException {

        ModelAndView model = new ModelAndView("addNewPayment");


        Payment payment= new Payment();

        payment.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
        payment.setStaff_id(Integer.parseInt(request.getParameter("staff")));
        payment.setRental_id(Integer.parseInt(request.getParameter("rental_id")));
        BigDecimal myAmount = new BigDecimal(request.getParameter("amount"));
        payment.setAmount(myAmount);
        payment.setPayment_date(new Date());
        payment.setLast_update(new Timestamp(System.currentTimeMillis()));

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        validate(payment, validator);

        paymentDAO.create(payment);
        model.addObject("newffPayment", payment);

        return model;
    }

    @Transactional
    @RequestMapping(value = "addNewPayment", method = {RequestMethod.GET})
    public  ModelAndView showForm(HttpServletRequest request)  {

        ModelAndView model = new ModelAndView("addNewPayment");
        Payment payment = new Payment();
        String customer_id = request.getParameter("customer_id");
        payment.setCustomer_id(Integer.parseInt(customer_id));
        payment.setAmount(BigDecimal.valueOf(0.000f));
        payment.setPayment_date( new Date());

        List<Staff> myStaffList=new ArrayList<Staff>();
        List<Rental> myRentalsList = new ArrayList<Rental>();

        try{
        myStaffList=staffDAO.getAll();
        myRentalsList=rentalDAO.getAllRentalsByCustId(Integer.parseInt(customer_id));

        } catch (DBException ex) {
            ex.printStackTrace();
        }

        model.addObject("newEmptyPayment", payment);
        model.addObject("staff_list",myStaffList);
        model.addObject("rental_list",myRentalsList);
        return model;
    }


}
