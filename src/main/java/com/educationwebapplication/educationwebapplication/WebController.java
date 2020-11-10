package com.educationwebapplication.educationwebapplication;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class WebController {

    JdbcConnectivity jdbcConnectivity = new JdbcConnectivity();
    ArrayList<String> subjects = new ArrayList<String>();


    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contactUs() {
        return "contact";
    }


    @RequestMapping("/curriculums")
    public String curriculums() {
        return "curriculums";
    }
    @RequestMapping("/teachersearch")
    public String teacherSearch() {
        return "teacherSearch";
    }

    @RequestMapping("/resources")
    public String resources(Model model) {
        List<Resource> resourceList = jdbcConnectivity.loadResources();
        model.addAttribute("resourceList", resourceList);
        return "resources";
    }

    @RequestMapping("/studentprofile")
    public String studentProfile(Model model) {
        List<Resource> userResourceList = jdbcConnectivity.loadUserResources();
        model.addAttribute(userResourceList);
        return "studentProfile";
    }

    @RequestMapping("/resourcesbysubject")
    public String resourceBySubject(Model model) {
        List<Resource> resourceList = jdbcConnectivity.loadResources();
        for(Resource resource: resourceList) {
            String subject = resource.getResourceType();
            if(!subjects.contains(subject)) {
                subjects.add(subject);
            }
        }
        model.addAttribute("subjects", subjects);
        model.addAttribute("resources", resourceList);
        return "resourcesBySubject";
    }



    @RequestMapping("/math")
    public String math() {
        return "math";
    }
    @RequestMapping("/english")
    public String english() {
        return "english";
    }
    @RequestMapping("/science")
    public String science() {
        return "science";
    }
    @RequestMapping("/astronomy")
    public String astronomy() {
        return "astronomy";
    }


    @GetMapping("/studentsignup")
    public String studentSignUp(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentSignUp";
    }

    @PostMapping("studentsignup")
    public String addStudent(@ModelAttribute("student") Student student) {
        jdbcConnectivity.addStudent(student.getfName(), student.getlName(), student.getEmail(),
                                student.getUserName(), student.getPassword(), student.getGradeLevel());
        return "studentProfile";
    }


    @GetMapping("/teachersignup")
    public String teacherSignUp(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacherSignUp";
    }

    @PostMapping("teachersignup")
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
        jdbcConnectivity.addTeacher(teacher.getfName(), teacher.getlName(), teacher.getEmail(),
                teacher.getUserName(), teacher.getPassword(), teacher.getSubject());
        return "resources";
    }

    @GetMapping("/login")
    public String login(Model model) {
        Student student = new Student();
        model.addAttribute("user", student);
        return "login";
    }

    @PostMapping("login")
    public String loginUser(@ModelAttribute("student") Student student) {
        boolean loginSucess = jdbcConnectivity.login(student.getUserName(), student.getPassword());
        if(loginSucess)
            return "/studentProfile";
        else
            return "/login";
    }

}
