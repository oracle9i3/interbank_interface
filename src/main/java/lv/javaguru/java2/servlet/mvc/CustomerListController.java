package lv.javaguru.java2.servlet.mvc;
import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.CustomerDAOImpl;
import lv.javaguru.java2.domain.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Svetlana Titova on 17.08.2016.
 */
public class CustomerListController implements MVCController{
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public MVCModel execute(HttpServletRequest request) throws DBException {

        List<Customer> myList = customerDAO.getAll();
        return new MVCModel(myList, "/customerList.jsp");
         }
         }
