package lv.javaguru.java2.database.filter;

import lv.javaguru.java2.domain.PageInfo;

import java.sql.Timestamp;

/**
 * Created by Svetlana Titova on 13.09.2016.
 */
public class CustomerFilter extends PageInfo{
    private Integer customer_id;
    private String  first_name;
    private String  last_name;
    private String  email;
    private int active;
    private Timestamp last_update;

//    public CustomerFilter(String firstPageURI, String lastPageURI, String nextPageURI, String prevPageURI, String currentPage) {
//        super(firstPageURI, lastPageURI, nextPageURI, prevPageURI, currentPage);
//    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
}
