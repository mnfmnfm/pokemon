package com.ferreirae.michelle.pokemon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    @GetMapping("/")
    public String getRoot() {
        // specify which view (template) to use
        return "homepage";
    }
}
