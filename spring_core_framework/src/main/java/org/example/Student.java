package org.example;

import org.example.Payment.Payment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {

    private final Laptop laptop;
    private final Payment payment;

    public Student(Laptop laptop,@Qualifier("upiPayment") Payment payment) {
        this.laptop = laptop;
        this.payment = payment;
    }

    public void getStudent(){
        laptop.code();
        payment.pay();
        System.out.println("getStudent and that student is studying");
    }
    public String EditName(String name){
        name = name.toUpperCase();
        name = "name:"+name;
        return name+name;
    }
}
