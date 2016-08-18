package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.domain.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
public class PaymentDAOImpl  extends DAOImpl implements PaymentDAO{

    public  List<Payment>  getAllPaymentByCustId(int id) throws DBException {
        Connection connection = null;
        List<Payment> payments = new ArrayList<Payment>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from PAYMENT where payment_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Payment payment = null;
            while (resultSet.next()) {
                payment = new Payment();
                payment.setPayment_id(resultSet.getInt("payment_id"));
                payment.setPayment_date(resultSet.getDate("payment_date"));
                payment.setAmount(resultSet.getFloat("amount"));
            }
            return payments;
        } catch (Throwable e) {
            System.out.println("Exception while execute PaymentDAOImpl.getPaymentById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }


}

