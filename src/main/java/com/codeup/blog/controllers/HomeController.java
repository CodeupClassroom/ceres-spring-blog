package com.codeup.blog.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model viewModel){
        System.out.println((SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        return "home";
    }
}
