package com.dba9514.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //Create a mapping for "/hello

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("date", new java.util.Date());

        //This string should match the template file (.html etc...)
        return "helloworld";
    }
}
