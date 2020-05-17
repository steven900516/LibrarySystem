package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }
    @RequestMapping("/LibrarySystem")
    public String LibrarySystem(){return "LibrarySystem.html";}

//    public String LibrarySystem(){return "LibrarySystem.html";}
//    @RequestMapping("/LibrarySystem")
//    public String LibrarySystem(){return "LibrarySystem.html";}
//    @RequestMapping("/LibrarySystem")
//    public String LibrarySystem(){return "LibrarySystem.html";}
}
