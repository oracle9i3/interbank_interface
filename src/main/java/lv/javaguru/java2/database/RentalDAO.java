package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Rental;

import java.util.List;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */

public interface RentalDAO {
    List<Rental> getAllRentalsByCustId(int id) throws DBException;
}
