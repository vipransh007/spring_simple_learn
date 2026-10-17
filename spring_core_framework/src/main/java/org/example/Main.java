package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    @Bean
    public String checkString(){
        return "checkString and checking...";
    }


    static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Student student = context.getBean(Student.class);
        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);

        Laptop l1 = context.getBean(Laptop.class);
        Laptop l2 = context.getBean(Laptop.class);

        System.out.println(l1 == l2);
        System.out.println(s1 == s2);
        student.getStudent();
    }
}
