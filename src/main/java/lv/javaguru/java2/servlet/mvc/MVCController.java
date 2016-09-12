package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public interface MVCController {

   // MVCModel execute(HttpServletRequest request) throws DBException;
  // public interface MVCController {
       MVCModel processRequest(HttpServletRequest request,
                               HttpServletResponse response);
   }

