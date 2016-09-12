package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping("/index")
public class HelloWorldController {
    @Autowired
    @Qualifier("ORM_UsersDAO")
    private UserDAO userDAO;// = new UserDAOImpl(); // novoe
    HttpSession session;
    //    public MVCModel execute(HttpServletRequest request) throws DBException{ // esli user uzhe chro-to vbil na forme v UI to vidno v request
//
//           // Long userId  = Long.parseLong((String)request.getAttribute("model"));
//
//            //User user = userDAO.getById(1003);
//          List<User> myList = userDAO.getAll();
//            return new MVCModel(myList, "/helloWorld.jsp");
//
//    }
  //  public class MyResultList {
      //  private List<User> users;
     //  public MyResultList(List<User> users) {
     //   this.users = users;
   // }
//    public class MyResultList{
//        private List<User> users;
//
//        public MyResultList(List<User> users) {
//            this.users = users;
//        }
//
//        public List<User> getUser() {
//            return users;
//        }
//
//        public Integer getUserId()
//        {return this.getUserId(); }
//
//        public void setUsers(List<User> users) {
//            this.users = users;
//        }
//
//     }
@RequestMapping(value = "index", method = {RequestMethod.GET})
public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView model  = new ModelAndView("helloWorld");
    List<User> myList = null;

    session = request.getSession();
  try{
     myList =  userDAO.getAll();
    } catch (DBException ex) {

    }

   model.addObject("model", myList);

    return model;
}

}
