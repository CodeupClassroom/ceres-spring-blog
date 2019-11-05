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

        ArrayList<Ad> adsList = new ArrayList<Ad>();

        adsList.add(new Ad(1,"first ad", "new"));
        adsList.add(new Ad(2,"second ad", "new"));
        adsList.add(new Ad(3,"third ad", "used"));

        viewModel.addAttribute("ads", adsList);

        return "home";
    }
}
