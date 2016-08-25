package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Customer;

import java.util.List;

/**
 * Created by Svetlana Titova on 17.08.2016.
 */

public interface CustomerDAO {

    List<Customer> getAll() throws DBException;

}
