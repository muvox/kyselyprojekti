package com.kysely.kyselyprojekti.web;

import com.kysely.kyselyprojekti.domain.KyselyRepository;
import com.kysely.kyselyprojekti.model.Kysely;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Controller
public class KyselyController {

    @Autowired
    KyselyRepository repo;

    @RequestMapping(value="/")
    public String kysely(Model model){
        model.addAttribute("kysely", repo.findAll());
        return "index";
    }
}
