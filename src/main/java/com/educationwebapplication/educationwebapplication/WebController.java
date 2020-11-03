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
        Student student = new Student();
        model.addAttribute("user", student);
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
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentSignUp";
    }

    @PostMapping("signup")
    public String addUser(@ModelAttribute("student") Student student) {
        jdbcConnectivity.addUser(student.getfName(), student.getlName(), student.getEmail(),
                                student.getUserName(), student.getPassword(), student.getGradeLevel());
        return "resources";
    }

    @GetMapping("/teachersignup")
    public String teacherSignUp() {
        return "teacherSignUp";
    }


    @PostMapping("login")
    public String login(@ModelAttribute("user") Student student) {
        boolean loginSucess = jdbcConnectivity.login(student.getUserName(), student.getPassword());
        if(loginSucess)
            return "/resources";
        else
            return "/login";
    }

}
