package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.StaffDAO;
import lv.javaguru.java2.domain.Staff;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */
@Component("JDBC_StaffDAO")
public class StaffDAOImpl extends DAOImpl implements StaffDAO {

       // @Override
        public List<Staff> getAll() throws DBException {
            List<Staff>  staffs = new ArrayList<Staff>();
            Connection connection = null;
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from STAFF");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Staff staff= new Staff();
                    staff.setStaff_Id(resultSet.getInt("staff_id"));
                    staff.setFirstName(resultSet.getString("first_name"));
                    staff.setLastName(resultSet.getString("last_name"));

                    staff.setUsername(resultSet.getString("email"));

                    staffs.add(staff);
                }
            } catch (Throwable e) {
                System.out.println("Exception while getting customer list StaffDAOImpl.getAll()");
                e.printStackTrace();
                throw new DBException(e);
            } finally {
                closeConnection(connection);
            }
            return staffs;
        }
}
