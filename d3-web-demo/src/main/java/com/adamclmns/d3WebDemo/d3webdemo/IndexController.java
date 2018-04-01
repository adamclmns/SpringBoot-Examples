package com.adamclmns.d3WebDemo.d3webdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class IndexController {
    @RequestMapping("")
    public String getIndexView(Model model, HttpServletRequest request){
        // Model is automagically provided to your method.
        // Add attributes to <String,Object> Map that is model
        model.addAttribute("message", "This is a String, but you could use a Map, or a list, or numbers, or a complex object and access fields within it from the thymeleaf template");
        return "index";

    }
}
