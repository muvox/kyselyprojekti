package com.kysely.kyselyprojekti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kysely.kyselyprojekti.model.*;
import com.kysely.kyselyprojekti.repository.KyselyRepository;
import com.kysely.kyselyprojekti.repository.KysymysRepository;
import com.kysely.kyselyprojekti.repository.VastausRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/rest/uusiVastaus")
    public void vastaus (@RequestBody Map<String, String> json) {
        Vastaus vastausEnt = new Vastaus();
        vastausEnt.setArvo(json.get("vastaus"));
        Optional<Kysymys> objecti = kysRepo.findById(Long.parseLong(json.get("kysymysid")));

        if(objecti.get().getId()!=null) {
            vastausEnt.setKysymys(objecti.get());
        } else {
            System.out.println("No suchs kysymys id");
        }
        vasRepo.save(vastausEnt);
//TODO: vastausten koppaaminen
    }

    @PostMapping(value="/rest/montaVastausta")
    public void montaVastausta(@RequestBody Payload vastaukset){
        System.out.println("tässä tulee payload"+vastaukset);
        System.out.println("tässä vielä lista payload tavvarasta listana :"+vastaukset.getVastaukset());
        for(VastausJson v : vastaukset.getVastaukset()){
            Vastaus vastausEntity = new Vastaus();
            vastausEntity.setArvo(v.getVastaus());
            String kysId = v.getKysymysid();
            Optional<Kysymys> objecti = kysRepo.findById(Long.parseLong(kysId));

            if(objecti.get().getId()!=null) {
                vastausEntity.setKysymys(objecti.get());
            } else {
                System.out.println("No suchs kysymys id");
            }

            vasRepo.save(vastausEntity);
        }
    }

    @GetMapping(value="/vastaukset")
    public Iterable<Vastaus> kaikkiVastaukset() {return vasRepo.findAll();}
}
