package com.educationwebapplication.educationwebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }



    @RequestMapping("/resources")
    public String resources() {
        return "resources";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signUp";
    }

    @PostMapping("signup")
    public String submitForm(@ModelAttribute("user") User user) {
        System.out.println(user.toString());
        return resources();
    }



}
