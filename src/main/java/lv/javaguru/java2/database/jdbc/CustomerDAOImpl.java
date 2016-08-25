package lv.javaguru.java2.database.jdbc;
import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Customer;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svetlana Titova on 17.08.2016.
 */
@Component
public class CustomerDAOImpl extends DAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll() throws DBException {
        List<Customer> customers = new ArrayList<Customer>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CUSTOMER");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirst_name(resultSet.getString("first_name"));
                customer.setLast_name(resultSet.getString("last_name"));
                customer.setActive(resultSet.getShort("active"));
                customer.setEmail(resultSet.getString("email"));
                customer.setCreate_date(resultSet.getDate("create_date"));
                customer.setLast_update(resultSet.getTimestamp("last_update"));
                customers.add(customer);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CustomerDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return customers;
    }
}
