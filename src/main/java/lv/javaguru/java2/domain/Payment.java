package lv.javaguru.java2.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Svetlana Titova on 18.08.2016.
 */
public class Payment {
    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    private int payment_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    private int customer_id;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    private int staff_id;

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    private int rental_id ;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

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

    private Float  amount;

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    private Date payment_date;

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    private Timestamp last_update;



}
