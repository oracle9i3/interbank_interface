package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Svetlana Titova on 17.08.2016.
 */

public interface CustomerDAO {

    List<Customer> getAll() throws DBException;
    List<Customer> getRange(int startRow, int rowCount ,HttpServletRequest request) throws DBException;
    Customer getCustomerById(int id) throws DBException;
}
