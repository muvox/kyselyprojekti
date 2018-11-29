package com.kysely.kyselyprojekti.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VastausJson {

    @JsonProperty("vastaus")
    private String vastaus;

    @JsonProperty("kysymysid")
    private String kysymysid;


    public VastausJson(String vastaus, String kysymysid) {
        this.vastaus = vastaus;
        this.kysymysid = kysymysid;
    }

    public VastausJson() {}


    public String getVastaus() {
        return vastaus;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }

    public String getKysymysid() {
        return kysymysid;
    }

    public void setKysymysid(String kysymysid) {
        this.kysymysid = kysymysid;
    }

}
