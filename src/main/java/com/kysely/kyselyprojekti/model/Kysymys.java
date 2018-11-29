package com.kysely.kyselyprojekti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a1704471 on 29.10.2018.
 */
@Entity
@Table(name = "kysymykset")
public class Kysymys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "type")
    private
    String type;

    @Column(name = "body")
    private String body;

    @ElementCollection
    private List<String> vaihtoehdot = new ArrayList<String>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kysely_id")
    private Kysely kysely;

    public Kysymys(Kysely kysely, String body, String type){
        this.kysely = kysely;
        this.body = body;
        this.type = type;
    }

    public Kysymys(Kysely kysely, String body, String type, List<String> vaihtoehdot){
        this.kysely = kysely;
        this.body = body;
        this.type = type;
        this.vaihtoehdot = vaihtoehdot;
    }
    public Kysymys(String body) {
        this.body = body;
    }

    public Kysymys(String body, Kysely kysely) {
        this.body = body;
        this.type = type;
        this.kysely = kysely;
    }


    public Kysymys() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Kysely getKysely() {
        return kysely;
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }

    public List<String> getVaihtoehdot() {
        return vaihtoehdot;
    }

    public void setVaihtoehdot(List<String> vaihtoehdot) {
        this.vaihtoehdot = vaihtoehdot;
    }
}
