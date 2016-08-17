package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HelloWorldController implements MVCController {
  private UserDAO userDAO = new UserDAOImpl(); // novoe

    public MVCModel execute(HttpServletRequest request) throws DBException{ // esli user uzhe chro-to vbil na forme v UI to vidno v request

           // Long userId  = Long.parseLong((String)request.getAttribute("model"));

            //User user = userDAO.getById(1003);
          List<User> myList = userDAO.getAll();
            return new MVCModel(myList, "/helloWorld.jsp");

    }

}
