package com.kysely.kyselyprojekti.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kysely.kyselyprojekti.model.Kysymys;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Entity
@Table(name="kyselyt")
public class Kysely {

    @OneToMany(mappedBy = "kysely", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    List<Kysymys> kysymykset;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="title")
    private String title;

    public Kysely() {
    }

    public Kysely(String title){
        this.title = title;
    }

    public Kysely(List<Kysymys> kysymykset){
        this.kysymykset = kysymykset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Kysymys> getKysymykset() {
        return kysymykset;
    }

    public void setKysymykset(List<Kysymys> kysymykset) {
        this.kysymykset = kysymykset;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Kysely{" +
                "id=" + id +
                ", kysymykset=" + kysymykset +
                '}';
    }
}
