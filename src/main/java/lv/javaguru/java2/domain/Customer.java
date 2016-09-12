package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Svetlana Titova on 17.08.2016.
 */
@Entity
@Table(name ="customer")
public class Customer {

   @Id
   @Column(name="customer_id", columnDefinition = "smallint")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer customer_id;

   @Column(name="store_id", columnDefinition = "TINYINT")
   private int store_id;

   private String  first_name;
   private String  last_name;
   private String  email;

   @Column(name="address_id",columnDefinition = "smallint")
   private Integer address_id;

   @Column(name="active", columnDefinition ="bit")
   private int active;
   private Date create_date;
   private Timestamp last_update;

   // @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,
   //           cascade = CascadeType.REMOVE, orphanRemoval = true)
   // private List<Payment> payments;

    public Customer() {
    }

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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
