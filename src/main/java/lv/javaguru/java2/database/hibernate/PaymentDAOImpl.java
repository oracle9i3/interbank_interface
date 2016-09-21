package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Svetlana Titova on 26.08.2016.
 */
@Component("ORM_PaymentsDAO")
@Transactional
public class PaymentDAOImpl extends DAOImpl implements PaymentDAO {
    @Autowired
    @Qualifier("ORM_CustomerDAO")
    private CustomerDAO customerDAO;
    private Customer customer = null;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public  List<Payment>  getAllPaymentByCustId(int id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Payment.class).list();

    }

    public void create(Payment payment) throws DBException {
        if (payment == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into payment (customer_id, staff_id, rental_id, amount ,payment_date,last_update) values (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, customer.getCustomer_id());
            preparedStatement.setInt(2, 1/*payment.getStaff_id()*/);
            preparedStatement.setInt(3, 1/*payment.getRental_id()*/);
            preparedStatement.setBigDecimal(4, payment.getAmount());
            preparedStatement.setDate(5,(Date)payment.getPayment_date());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
                payment.setPayment_id(rs.getInt(1));
                if (rs.next()){
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute PaymentDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }
}
