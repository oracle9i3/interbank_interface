package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */
@Repository("ORM_StaffDAO")
@Component("ORM_StaffDAO")
@Transactional
public class StaffDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Staff> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Staff.class).list();
    }
}
