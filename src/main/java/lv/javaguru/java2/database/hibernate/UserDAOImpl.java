package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Svetlana Titova on 26.08.2016.
 */
@Component("ORM_UsersDAO")
@Transactional
public class UserDAOImpl extends DAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() throws DBException {

        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }
    @Override
    public void create(User user) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }
    @Override
    public void update(User user) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(Integer id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public void delete(Integer id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.delete(user);
    }

}
