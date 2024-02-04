package com.dba9514.thymeleafdemo.controller;

import com.dba9514.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    //Injecting Values directly from the application.properties file.
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    //Adding a Student object to the model
    //This give the ability to modify / access the attributes with the front end via thymeleaf tags.
    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        //Create student object
        var student = new Student();

        //Add student to model
        model.addAttribute("student", student);

        //Add countries to the model
        model.addAttribute("countries", countries);

        //Add languages to the model
        model.addAttribute("languages", languages);

        //Add operating systems to the model
        model.addAttribute("systems", systems);

        //.html name
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {

        // Log the input data
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

        //.html name
        return "student-confirmation";
    }


}
