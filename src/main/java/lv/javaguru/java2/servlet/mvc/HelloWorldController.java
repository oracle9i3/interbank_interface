package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class HelloWorldController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Hello from MVC", "/helloWorld.jsp");
    }

}
