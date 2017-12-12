package com.vavv.web.controller;

import com.vavv.web.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping("/hello")
    public String sayHello() {
        return "login-hello";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public void login(@RequestBody User user) {
        System.out.println("User: " + user);
    }

    /*@RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "globe") String name) {
        System.out.println("Name sent: " + name);
        return new Greeting(1, "hello " + name);
    }*/
}
