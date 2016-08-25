package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.domain.Payment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
@Component
public class PaymentDAOImpl  extends DAOImpl implements PaymentDAO{

    public  List<Payment>  getAllPaymentByCustId(int id) throws DBException {
        Connection connection = null;
        List<Payment> payments = new ArrayList<Payment>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from PAYMENT where customer_id= ? ORDER BY payment_id, payment_date ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setPayment_id(resultSet.getInt("payment_id"));
                payment.setPayment_id(resultSet.getInt("customer_id"));
                payment.setAmount(resultSet.getFloat("amount"));
                payment.setLast_update(resultSet.getTimestamp("last_update"));
                payment.setPayment_date(resultSet.getDate("payment_date"));
                payments.add(payment);
            }
            return payments;
        } catch (Throwable e) {
            System.out.println("Exception while execute PaymentDAOImpl.getAllPaymentByCustId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }


}

