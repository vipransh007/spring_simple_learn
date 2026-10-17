package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllerApp {

    @GetMapping("")
    public String index() {
        System.out.println("index");
        return "madarchod apni maa chuda na yaha kya baitha hua hai";
    }
}
