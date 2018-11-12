package com.kysely.kyselyprojekti.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import com.kysely.kyselyprojekti.model.Kysymys;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Entity(name = "kysely")
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @NotEmpty
    private Long id;

    @ManyToOne(targetEntity=com.kysely.kyselyprojekti.model.Kysymys.class)
    private List<Kysymys> kysymykset;

    public Kysely() {
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


    @Override
    public String toString() {
        return "Kysely{" +
                "id=" + id +
                ", kysymykset=" + kysymykset +
                '}';
    }
}
