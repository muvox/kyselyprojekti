package com.kysely.kyselyprojekti.model;

import javax.persistence.*;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String data;

    public Kysely() {
    }

    public Kysely(String data){
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Kysely{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
