package com.springtutorial.SpringBootOverview.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @GetMapping()
    public String sayHello() {
        return coachName;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run for 5 km";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day";
    }

}
