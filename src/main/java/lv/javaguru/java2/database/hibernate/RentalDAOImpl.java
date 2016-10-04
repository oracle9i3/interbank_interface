package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */
@Repository("ORM_RentalDAO")
@Component("ORM_RentalDAO")
public class RentalDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;
    //@Override
    public List<Payment> getAllRentalsByCustId(int id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Payment.class).list();

    }
}
