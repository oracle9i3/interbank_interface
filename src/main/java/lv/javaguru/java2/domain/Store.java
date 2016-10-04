package lv.javaguru.java2.domain;

/**
 * Created by Svetlana Titova on 9/22/2016.
 */
public class Store {
    private Integer store_id;
    private Integer manager_staff_id;
    private Integer address_id;
    private String address;

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(Integer manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
