package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloWithName(@PathVariable String name, Model viewModel){
        viewModel.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "team") String cohort, Model vModel) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Mark");
        students.add("Juan");
        students.add("Luisa");

        vModel.addAttribute("msg", "Welcome to " + cohort + "!");
        vModel.addAttribute("students", students);

        return "join";
    }

}
