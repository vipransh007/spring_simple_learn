package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Laptop {
    public void code() {
        System.out.println("Laptop");
    }
    public String name(){
        return "Name of the Laptop......";
    }
}
