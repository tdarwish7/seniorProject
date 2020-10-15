package com.educationwebapplication.educationwebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
