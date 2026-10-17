package org.example.Payment;

import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("The payment will be made through UPI");
    }
}
