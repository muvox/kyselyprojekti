package com.kysely.kyselyprojekti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kysely.kyselyprojekti.model.*;
import com.kysely.kyselyprojekti.repository.KyselyRepository;
import com.kysely.kyselyprojekti.repository.KysymysRepository;
import com.kysely.kyselyprojekti.repository.VastausRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

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

    @GetMapping(value = "/rest/kyselyt")
    public Iterable<Kysely> kyselyt() {
        return repo.findAll();
    }

    @GetMapping(value = "/rest/kyselyt/{id}")
    public Optional<Kysely> readKysely(@PathVariable("id") Long kyselyId) {

        return repo.findById(kyselyId);
    }

    @GetMapping(value = "/rest/kysymykset")
    public Iterable<Kysymys> kysymykset() {
        return kysRepo.findAll();
    }

    @GetMapping(value = "/rest/kysymykset/{id}")
    public Optional<Kysymys> readKysymys(@PathVariable("id") Long kysymysId) {

        return kysRepo.findById(kysymysId);
    }

    @PostMapping(value = "/rest/yksivastaus")
    public void vastaus(@RequestBody Map<String, String> json) {
        Vastaus vastausEnt = new Vastaus();
        vastausEnt.setArvo(json.get("vastaus"));
        Optional<Kysymys> objecti = kysRepo.findById(Long.parseLong(json.get("kysymysid")));

        if (objecti.get().getId() != null) {
            vastausEnt.setKysymys(objecti.get());
        } else {
            System.out.println("No suchs kysymys id");
        }
        vasRepo.save(vastausEnt);
    }

    @PostMapping(value = "/rest/montavastausta")
    public void postMultipleVastaus(@RequestBody List<VastausJson> vastaukset){
        for(VastausJson v : vastaukset){
            Vastaus vastaus = new Vastaus();
            vastaus.setArvo(v.getVastaus());
            vastaus.setKysymys(kysRepo.findById(Long.parseLong(v.getKysymysid())).get());
            vasRepo.save(vastaus);
        }
    }


    @GetMapping(value = "/rest/vastaukset")
    public Iterable<Vastaus> kaikkiVastaukset() {
        return vasRepo.findAll();
    }

    @GetMapping(value = "/rest/vastaukset/{id}")
    public List<Vastaus> vastauksetPerId(@PathVariable("id") Long kysymysId){
        Iterable<Vastaus> vastaukset = vasRepo.findAll();
        List<Vastaus> vastausLista = new ArrayList<Vastaus>();
        for(Vastaus v : vastaukset){
            vastausLista.add(v);
        }

        List<Vastaus> tulosteLista = new ArrayList<Vastaus>();
        for(Vastaus v : vastausLista){
            System.out.println(v.getKysymys().getId());
            if(v.getKysymys().getId()==kysymysId) {
                tulosteLista.add(v);
            }
        }

        return tulosteLista;

    }

}
