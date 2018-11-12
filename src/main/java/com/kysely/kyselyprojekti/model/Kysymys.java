package com.kysely.kyselyprojekti.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a1704471 on 29.10.2018.
 */
@Entity
public class Kysymys {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @NotNull
    private String value;

    public Kysymys(String value) {
        this.value = value;
    }

    public Kysymys() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Kysymys{" +
                "id=" + id +
                ", value='" + value + '\'';
    }
}
