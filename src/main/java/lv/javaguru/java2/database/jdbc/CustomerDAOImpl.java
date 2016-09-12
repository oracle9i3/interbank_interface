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
@Component("JDBC_CustomerDAO")
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
            System.out.println("Exception while getting customer list CustomerDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return customers;
    }
    @Override
    public List<Customer> getRange(int startRow, int rowCount) throws DBException {
        List<Customer> customers = new ArrayList<Customer>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement("SELECT * FROM customer ORDER BY customer_id "
                    + "LIMIT " + rowCount + " OFFSET " + startRow);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirst_name(resultSet.getString("first_name"));
                customer.setLast_name(resultSet.getString("last_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setActive(resultSet.getInt("active"));
                customer.setCreate_date(resultSet.getDate("create_date"));
                customer.setLast_update(resultSet.getTimestamp("last_update"));

                customers.add(customer);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CustomerDAOImpl.getRange()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return customers;
    }

     public Customer getCustomerById(int id) throws DBException {

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CUSTOMER where customer_id=?");

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer  customer = new Customer();
           if (resultSet.next()) {

                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirst_name(resultSet.getString("first_name"));
                customer.setLast_name(resultSet.getString("last_name"));
                customer.setActive(resultSet.getShort("active"));
                customer.setEmail(resultSet.getString("email"));
                customer.setCreate_date(resultSet.getDate("create_date"));
                customer.setLast_update(resultSet.getTimestamp("last_update"));

            }
            return customer;
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CustomerDAOImpl.getCustomerById");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
