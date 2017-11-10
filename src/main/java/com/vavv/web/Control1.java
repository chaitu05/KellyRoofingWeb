package com.vavv.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  * Created by cmynam on 11/9/17.
 *   */
@RestController
@RequestMapping("/control1")
public class Control1 {
	@RequestMapping("/hello")
	public String sayHello() {
		return "ello";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
		public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "globe") String name) {
			System.out.println("Name sent: " + name);
			return new Greeting(1, "hello " + name);
		}
}

