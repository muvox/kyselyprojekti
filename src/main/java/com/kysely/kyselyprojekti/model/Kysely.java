package com.kysely.kyselyprojekti.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "kysymykset")
    private List<String> kysymykset = new ArrayList<String>();

    public Kysely() {
    }

    public Kysely(List<String> kysymykset){
        this.kysymykset = kysymykset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getKysymykset() {
        return kysymykset;
    }

    public void setKysymykset(List<String> kysymykset) {
        this.kysymykset = kysymykset;
    }


    @Override
    public String toString() {
        return "Kysely{" +
                "id=" + id +
                ", kysymykset=" + kysymykset +
                '}';
    }
}
