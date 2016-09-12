package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.PageInfo;
import org.hibernate.SessionFactory;
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

/**
 * Created by Svetlana Titova on 17.08.2016.
 */
@Controller

public class CustomerListController {
    @Autowired
    @Qualifier("ORM_CustomerDAO")
    private CustomerDAO customerDAO;

    @Autowired
    private SessionFactory sessionFactory;

    HttpSession session;

@RequestMapping(value ={"main" , ""}, method = {RequestMethod.GET})
public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView model  = new ModelAndView("customerList");
    List<Customer> myList = null;
    List<Customer> myFullList = null;
    int rowsPerPage=9;
    session = request.getSession();

    String page = request.getParameter("page");
    if (page == null) page = "1";
    else if (Integer.parseInt(page) < 1) page = "1";

    try{
         myFullList=customerDAO.getAll();
         myList =customerDAO.getRange((Integer.parseInt(page) - 1) ,rowsPerPage);//TO DO
    } catch (DBException ex) {

    }
    if (Integer.parseInt(page) > myFullList.size()/rowsPerPage) {page = "1";}

    String firstPage = (request.getRequestURI() + "?page=" + 1);
    String nextPage = (request.getRequestURI() + "?page=" + (Integer.parseInt(page) + 1));
    String prevPage;
    if (page=="1")
    {
        prevPage = (request.getRequestURI() + "?page=" + page);
    }
    else
    {prevPage = (request.getRequestURI() + "?page=" + (Integer.parseInt(page) - 1));}

    String lastPage = (request.getRequestURI() + "?page=" +  (myFullList.size())/rowsPerPage);

    System.out.println("Customers size: " +  myFullList.size());


   model.addObject("pageInfo", new PageInfo(firstPage,lastPage, nextPage, prevPage,  page));
   model.addObject("model", myList);
        return model;
    }
 }
