package ru.maxima.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // CRUD - create read update delete
    // @PostMapping - create
    // @GetMapping - read
    // @PutMapping - update
    // @PatchMapping - update
    // @DeleteMapping - delete

    @GetMapping("/old-hello-world")
    public String oldSayHello(HttpServletRequest request,
                              Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer age = Integer.valueOf(request.getParameter("age"));

        model.addAttribute("message", "Hello, " + name + ", " + surname);
        model.addAttribute("myAge", "My age is " + age + " years");

        System.out.println(name + " : " + surname);
        System.out.println("You are inside your controller");
        return "hello";
    }

    @GetMapping("/new-hello-world")
    public String newSayHello(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
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
