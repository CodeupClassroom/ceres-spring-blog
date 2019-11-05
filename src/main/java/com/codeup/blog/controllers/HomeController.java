package com.codeup.blog.controllers;

import com.codeup.blog.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model viewModel){
        return "home";
    }
}
