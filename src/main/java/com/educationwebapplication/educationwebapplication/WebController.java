package com.educationwebapplication.educationwebapplication;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class WebController {

    JdbcConnectivity jdbcConnectivity = new JdbcConnectivity();

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contactUs() {
        return "contact";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping("/resources")
    public String resources(Model model) {
        List<Resource> resourceList = jdbcConnectivity.loadResources();
        model.addAttribute("resourceList", resourceList);
        return "resources";
    }


    @GetMapping("/studentsignup")
    public String userSignUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "studentSignUp";
    }

    @PostMapping("signup")
    public String addUser(@ModelAttribute("user") User user) {
        jdbcConnectivity.addUser(user.getfName(), user.getlName(), user.getEmail(),
                                user.getUserName(), user.getPassword(), user.getGradeLevel());
        return "resources";
    }

    @GetMapping("/teachersignup")
    public String teacherSignUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "teacherSignUp";
    }


    @PostMapping("login")
    public String login(@ModelAttribute("user") User user) {
        boolean loginSucess = jdbcConnectivity.login(user.getUserName(), user.getPassword());
        if(loginSucess)
            return "/resources";
        else
            return "/login";
    }

}
