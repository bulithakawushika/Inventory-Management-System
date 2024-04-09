package com.uok.oop.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Handle the request to display the login page.
    @GetMapping("/login")
    public String login() {
        // Return the "login" view to display the login page.
        return "login";
    }
}
