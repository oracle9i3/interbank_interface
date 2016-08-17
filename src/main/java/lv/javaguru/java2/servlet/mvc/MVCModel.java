package lv.javaguru.java2.servlet.mvc;

public class MVCModel {

    private Object data; // tip dannih zaranee ne izvesten po etomu object
    private String viewName; // nazvanie UI componenta kotorij budet prorisovivat' model

    public MVCModel(Object data, String viewName) {
        this.data = data;
        this.viewName = viewName;
    }

    public Object getData() {
        return data;
    }

    public String getViewName() {
        return viewName;
    }
}
