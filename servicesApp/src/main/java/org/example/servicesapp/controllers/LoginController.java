package org.example.servicesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @PostMapping("/dashboard")
    public String login() {
        // You can add login logic here, like authentication check
        return "DashBoard.html"; // Redirects to the dashboard page
    }
}
