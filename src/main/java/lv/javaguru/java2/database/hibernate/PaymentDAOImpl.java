package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Svetlana Titova on 26.08.2016.
 */
@Component("ORM_PaymentsDAO")
@Transactional
public class PaymentDAOImpl extends DAOImpl implements PaymentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public  List<Payment>  getAllPaymentByCustId(int id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Payment.class).list();

    }
}
