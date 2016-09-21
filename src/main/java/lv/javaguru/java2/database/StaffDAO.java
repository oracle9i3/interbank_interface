package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Staff;
import java.util.List;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */
public interface StaffDAO {

    List<Staff> getAll() throws DBException;

}
