package com.MunteTutorial.HelloWorld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @GetMapping("/hello")
    public String GetHello() {
        return "Hello World!";
    }

}
