package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.Customer;

import java.util.Date;
import java.util.List;

/**
 * Created by Svetlana Titova on 03.10.2016.
 */
public class CustomerListForm {
    private String[] checked;
    private List<Customer> customers;
    //Filter data
    private String cust_id;
    private String email;
    private String first_name;
    private String last_name;
    private String status;
    private Date lastUpdate;

    private String exportCommand;
    private String action;

    public String getExportCommand() {
        return exportCommand;
    }

    public void setExportCommand(String exportCommand) {
        this.exportCommand = exportCommand;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }


    public String[] getChecked() {
        return checked;
    }

    public void setChecked(String[] checked) {
        this.checked = checked;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
