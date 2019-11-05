package com.codeup.blog.controllers;

import com.codeup.blog.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class AdController {

    ArrayList<Ad> adsList;

    public AdController() {
        adsList = new ArrayList<Ad>();

        adsList.add(new Ad(1,"first ad", "new"));
        adsList.add(new Ad(2,"second ad", "new"));
        adsList.add(new Ad(3,"third ad", "used"));
    }

    @GetMapping("/ads")
    public String index(Model viewModel){

        viewModel.addAttribute("ads", adsList);

        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("ad", adsList.get((int)id - 1));
        return "ads/show";
    }

    @GetMapping("/ads/create")
    @ResponseBody
    public String showCreateForm(){
        return "view the form for creating a ad";
    }

    @PostMapping("/ads/create")
    @ResponseBody
    public String create(@RequestParam String title, @RequestParam String body){
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        return "create a new ad";
    }

}
