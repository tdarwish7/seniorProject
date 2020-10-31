package com.educationwebapplication.educationwebapplication;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Controller
public class WebController {

    JdbcConnectivity jdbcConnectivity = new JdbcConnectivity();

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }



    @RequestMapping("/resources")
    public String resources(Model model) {
        List<Resource> resourceList = jdbcConnectivity.loadResources();
        model.addAttribute("resourceList", resourceList);
        return "resources";
    }


    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signUp";
    }

    @PostMapping("signup")
    public String addUser(@ModelAttribute("user") User user) {
        jdbcConnectivity.addUser(user.getfName(), user.getlName(), user.getEmail(),
                                user.getUserName(), user.getPassword(), user.getGradeLevel());
        return "resources";
    }



}
