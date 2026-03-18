package com.hei.springtd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name", required = false, defaultValue = "VIDE") String name) {
        System.out.println("=== NOM RECU : " + name + " ===");
        return "Welcome <" + name + ">";
    }
}