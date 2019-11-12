package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.repositories.AdRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adDao;
    private final UserRepository userDao;

    public AdController(AdRepository adDao, UserRepository userDao) {
        this.adDao = adDao;
        this.userDao = userDao;
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
    public String showCreateForm(Model vModel){
        vModel.addAttribute("ad" , new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String create(@ModelAttribute Ad adToBeCreated,
                         @RequestParam(name = "timeout") String timeout){
        System.out.println("timeout = " + timeout);
        adToBeCreated.setUser(userDao.getOne(1L));
        Ad savedAd = adDao.save(adToBeCreated);
        return "redirect:/ads/" + savedAd.getId();
    }

    @GetMapping("/ads/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("ad", adDao.getOne(id));
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String description) {
        Ad oldAd = adDao.getOne(id);
        oldAd.setTitle(title);
        oldAd.setDescription(description);
        adDao.save(oldAd);
        return "redirect:/ads/" + id;
    }

    @PostMapping("/ads/{id}/delete")
    public String delete(@PathVariable long id) {
        adDao.deleteById(id);
        return "redirect:/ads";
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
