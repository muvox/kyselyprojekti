package com.kysely.kyselyprojekti.controller;

import com.kysely.kyselyprojekti.repository.KyselyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
public class AppController {

    @Autowired
    KyselyRepository kysRepo;

    @RequestMapping(value="/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/adminPanel")
        public String panel(Model model){
            model.addAttribute("kyselyt", kysRepo.findAll());
            return "admin_panel";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteKysely(@PathVariable("id") Long kyselyId, Model model){
        kysRepo.deleteById(kyselyId);
        return "redirect:../adminPanel";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
}


