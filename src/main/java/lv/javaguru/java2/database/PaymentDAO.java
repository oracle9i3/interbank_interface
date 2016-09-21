package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Payment;

import java.util.List;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
public interface PaymentDAO {
    List<Payment> getAllPaymentByCustId(int id) throws DBException;
    void create(Payment payment) throws DBException;
}
