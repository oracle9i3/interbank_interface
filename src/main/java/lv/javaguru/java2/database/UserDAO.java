package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

import java.util.List;

public interface UserDAO {

    void create(User user) throws DBException;

    User getById(Integer id) throws DBException;

    void delete(Integer id) throws DBException;

    void update(User user) throws DBException;

    List<User> getAll() throws DBException;

}
