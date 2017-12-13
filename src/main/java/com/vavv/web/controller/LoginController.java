package com.vavv.web.controller;

import com.vavv.web.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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
    public ResponseEntity login(@RequestBody User user) {

        System.out.println("User: " + user);

        // query userRepository with username, pass

        // create JWT token with role, userId

        // create ResponseEntity with success to true and JWT token.

        HttpHeaders headers = new HttpHeaders();
        headers.add("1", "uno");
        return new ResponseEntity(new Object() {
            public final boolean success = true;
            public final Date dt = new Date();
            public final String str = "some string";
            public final char c = 'c';
            public final int n = 1234;
            public final long l = 333l;
            public final double d = 3.3d;
        }, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/signin-anonymous-obj-return", method = RequestMethod.POST)
    public ResponseEntity signinAnonymousObjectReturnSample(@RequestBody User user) {
        System.out.println("User: " + user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("1", "uno");
        return new ResponseEntity(new Object() {
            public final boolean success = true;
            public final Date dt = new Date();
            public final String str = "some string";
            public final char c = 'c';
            public final int n = 1234;
            public final long l = 333l;
            public final double d = 3.3d;
        }, headers, HttpStatus.OK);
    }

    /*@RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "globe") String name) {
        System.out.println("Name sent: " + name);
        return new Greeting(1, "hello " + name);
    }*/
}
