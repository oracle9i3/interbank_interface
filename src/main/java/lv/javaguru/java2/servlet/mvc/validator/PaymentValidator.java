package lv.javaguru.java2.servlet.mvc.validator;

import lv.javaguru.java2.domain.Payment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Svetlana Titova on 9/22/2016.
 */
public class PaymentValidator implements Validator {

 public boolean supports(Class clazz){
     return Payment.class.equals(clazz);
 }

    public void  validate(Object object, Errors error) {
       // Payment paymentForm = ((PaymentForm)target).getPayment();
       // rejectIfEmptyOrWhitespace(errors,"","");
    }
}
