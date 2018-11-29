package com.kysely.kyselyprojekti.controller;

import com.kysely.kyselyprojekti.model.Vastaus;
import com.kysely.kyselyprojekti.repository.KyselyRepository;
import com.kysely.kyselyprojekti.repository.KysymysRepository;
import com.kysely.kyselyprojekti.model.Kysely;
import com.kysely.kyselyprojekti.model.Kysymys;
import com.kysely.kyselyprojekti.repository.VastausRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by a1704471 on 25.10.2018.
 */
@RestController
public class KyselyController {

    @Autowired
    KyselyRepository repo;

    @Autowired
    KysymysRepository kysRepo;

    @Autowired
    VastausRepository vasRepo;

    @GetMapping(value="/rest/kyselyt")
    public Iterable<Kysely> kyselyt(){
        return repo.findAll();
    }

    @GetMapping(value="/rest/kyselyt/{id}")
    public Optional<Kysely> readKysely(@PathVariable("id") Long kyselyId){

        return repo.findById(kyselyId);
    }

    @GetMapping(value="/rest/kysymykset")
    public Iterable<Kysymys> kysymykset(){
        return kysRepo.findAll();
    }

    @GetMapping(value="/rest/kysymykset/{id}")
    public Optional<Kysymys> readKysymys(@PathVariable("id") Long kysymysId){

        return kysRepo.findById(kysymysId);
    }

    @PostMapping(value="/add")
    public void vastaus (@RequestBody Vastaus vastaus) {
        vasRepo.save(vastaus);
    }

    @GetMapping(value="/vastaukset")
    public Iterable<Vastaus> kaikkiVastaukset() {return vasRepo.findAll();}
}
