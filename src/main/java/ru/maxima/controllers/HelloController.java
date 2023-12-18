package ru.maxima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String sayHello() {
        System.out.println("You are inside your controller");
        return "hello";
    }

    @GetMapping("/name")
    public String sayName() {
        return "name";
    }

    @GetMapping("/address")
    public String sayAddress() {
        return "home";
    }
}
