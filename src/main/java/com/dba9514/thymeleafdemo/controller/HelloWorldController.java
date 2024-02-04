package com.dba9514.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    // Controller method to show initial form
    //The String value that is returned is the name of the .html(template) file.
    @GetMapping("/showForm")
    public String showForm() {
        return"helloworld-form";
    }

   // Controller method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //This is the long way to manually extract a parameter from the servlet request.
    @RequestMapping("/processFormVersionTwo")
    public String shout(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        // convert data to all caps
        name = name.toUpperCase();

        //create the message
        String result = "Yo! " + name;

        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    //This is the shortened version where I can just directly access the param from the form and assign it.
    @PostMapping("/processFormVersionThree")
    public String shoutShort(@RequestParam("studentName") String name, Model model) {
        // convert data to all caps
        name = name.toUpperCase();

        //create the message
        String result = "HEY! " + name;

        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }
}
