package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
@Entity
@Table(name ="payment")
public class Payment  {


    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    @Id
    @Column(name="payment_id", columnDefinition = "smallint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer payment_id;


   // @Version
   // private long version;

    @Column(name="customer_id", columnDefinition = "smallint")
    private Integer customer_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int payment_customer_id) {
        this.customer_id = payment_customer_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    @Column(name="staff_id", columnDefinition = "TINYINT")
    private int staff_id;

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    @Column(name="rental_id", columnDefinition="integer")
    private Integer rental_id ;

    @Column(name="amount", columnDefinition="decimal" ,precision=5)
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinTable(name="customer", joinColumns = @JoinColumn(name = "customer_id"))
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id" ,nullable = false, insertable=false, updatable=false)
//    private Customer customer;

//    public Customer getCustomer() {
//        return customer;
//    }

//   public void setCustomers(Customer customers) {
//    this.customer = customer;
//   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (getPayment_id() != payment.getPayment_id()) return false;
        if (getCustomer_id() != payment.getCustomer_id()) return false;
        if (getStaff_id() != payment.getStaff_id()) return false;
        if (getRental_id() != payment.getRental_id()) return false;
        if (!getAmount().equals(payment.getAmount())) return false;
        if (!getPayment_date().equals(payment.getPayment_date())) return false;
        return getLast_update().equals(payment.getLast_update());

    }

    @Override
    public int hashCode() {
        int result = getPayment_id();
        result = 31 * result + getCustomer_id();
        result = 31 * result + getStaff_id();
        result = 31 * result + getRental_id();
        result = 31 * result + getAmount().hashCode();
        result = 31 * result + getPayment_date().hashCode();
        result = 31 * result + getLast_update().hashCode();
        return result;
    }



    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Column(name="payment_date")
    private Date payment_date;

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    private Timestamp last_update;


}
