package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.RentalDAO;
import lv.javaguru.java2.domain.Rental;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */
@Component("JDBC_RentalDAO")
public class RentalDAOImpl extends DAOImpl implements RentalDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Rental> getAllRentalsByCustId(int id) throws DBException {
        Connection connection = null;
        List<Rental> rentals = new ArrayList<Rental>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from rental r " +
                            "join inventory i " +
                            "on i.inventory_id = r.inventory_id " +
                            "join film f " +
                            "on f.film_id= i.film_id " +
                            "where r.customer_id=? order by rental_date desc");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rental rental = new Rental();
                rental.setRental_id(resultSet.getInt("rental_id"));
                rental.setCustomer_id(resultSet.getInt("customer_id"));
                rental.setFilm_id(resultSet.getInt("film_id"));
                rental.setInventory_id(resultSet.getInt("inventory_id"));
                rental.setTitle(resultSet.getString("title"));
                rental.setDescription(resultSet.getString("description"));
                rental.setRental_date(resultSet.getTimestamp("rental_date"));

                rentals.add(rental);
            }
            return rentals;
        } catch (Throwable e) {
            System.out.println("Exception while execute RentalDAOImpl.getAllRentalsByCustId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
