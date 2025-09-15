package com.sanjtiksha.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";  // maps to templates/index.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }



    @GetMapping("/team")
    public String team() {
        return "team";
    }


    @GetMapping("/leadership")
    public String leadership() {
        return "leadership"; // loads leadership.html from templates
    }


}
