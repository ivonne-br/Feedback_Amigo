package com.FeedbackAmigo.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hola, equipo Feedback Amigo";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Adiós, equipo Feedback Amigo";
    }

    @GetMapping("/ivonne")
    public String ivonne() {
        return "Hola, soy Ivonne.<br>Integrante del equipo Feedback Amigo";
    }

    @GetMapping("/alany")
    public String alany() {
        return "Hola, soy AlanY.<br>Integrante del equipo Feedback Amigo";
    }

}
