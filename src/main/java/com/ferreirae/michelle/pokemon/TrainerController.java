package com.ferreirae.michelle.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class TrainerController {
    // Spring, you made a secret class that implements TrainerRepository.
    // Please give me an instance of that class.
    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/trainers")
    public RedirectView addTrainer(@RequestParam(name="handle") String username, String name, String password) {
        Trainer t = new Trainer(name, username, bCryptPasswordEncoder.encode(password));
        trainerRepository.save(t);
        Authentication authentication = new UsernamePasswordAuthenticationToken(t, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // dear Chrome, go make a Get request to this path instead
        return new RedirectView("/");
    }
}
