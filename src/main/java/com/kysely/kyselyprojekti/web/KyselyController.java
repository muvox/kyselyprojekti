package com.kysely.kyselyprojekti.web;

import com.kysely.kyselyprojekti.domain.KyselyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Controller
public class KyselyController {
    KyselyRepository repo;

    @RequestMapping(value="/")
    public String kysely(Model model){
        model.addAttribute("kysely", repo.findAll());
        return "booklist";
    }
}
