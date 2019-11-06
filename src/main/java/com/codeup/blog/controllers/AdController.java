package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model viewModel){
        viewModel.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("ad", adDao.getOne(id));
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

    // Repository Testing for JPA Lecture

    @GetMapping("/ads/search")
    @ResponseBody
    public Ad search() {
        return adDao.findByTitle("Gazella thompsonii");
    }

    @ResponseBody
    @GetMapping("/list-ads")
    public List<Ad> returnAds() {
        return adDao.findAll();
    }

    @ResponseBody
    @GetMapping("/ads/length")
    public List<String> returnAdsByLength() {
        return adDao.getAdsOfCertainTitleLength();
    }

    @ResponseBody
    @GetMapping("/ads/length/native")
    public List<String> returnAdsByLengthNative() {
        return adDao.getAdsOfCertainTitleLengthNative();
    }

}
