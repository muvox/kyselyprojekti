package com.kysely.kyselyprojekti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Vastaus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "arvo")
    private String arvo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kysymys_id")
    private Kysymys kysymys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArvo() {
        return arvo;
    }

    public void setArvo(String arvo) {
        this.arvo = arvo;
    }

    public Kysymys getKysymys() {
        return kysymys;
    }

    public void setKysymys(Kysymys kysymys) {
        this.kysymys = kysymys;
    }

    public Vastaus(String arvo, Kysymys kysymys) {
        this.arvo = arvo;
        this.kysymys = kysymys;
    }

    public Vastaus(String arvo){
        this.arvo = arvo;
    }

    public Vastaus() {
    }
}
