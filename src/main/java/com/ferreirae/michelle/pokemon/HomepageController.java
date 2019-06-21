package com.ferreirae.michelle.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomepageController {
    @Autowired
    TrainerRepository trainerRepository;

    @GetMapping("/")
    // Principal: because I want to get data about the logged-in user
    //      (a Principal is not a Trainer, one sec)
    // Model: because I want to give data to the template that I'm rendering
    public String getRoot(Principal p, Model m) {
        m.addAttribute("potato", "mashed");
        // WTF
        // what, true, false
        m.addAttribute("loggedInUserName", p == null ? "anonymous user" : p.getName());

        // pass in not just the username, but the full user object (Trainer instance)
        if (p != null) {
            m.addAttribute("trainer", trainerRepository.findByUsername(p.getName()));
        }
        // specify which view (template) to use
        return "homepage";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUpForm() {
        return "registration";
    }
}
