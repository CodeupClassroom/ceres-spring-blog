package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {

    @GetMapping("/ads")
    @ResponseBody
    public String index(){
        return "ads index page";
    }

    @GetMapping("/ads/{id}")
    @ResponseBody
    public String show(@PathVariable long id){
        return "view ad id = " + id;
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
