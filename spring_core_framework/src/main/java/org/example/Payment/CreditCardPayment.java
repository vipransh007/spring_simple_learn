package org.example.Payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditCardPayment  implements Payment {
    public void pay(){
        System.out.println("Payment for CreditCard");
    }
}
