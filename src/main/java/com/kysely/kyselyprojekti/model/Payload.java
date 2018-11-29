package com.kysely.kyselyprojekti.model;

import java.util.List;

public class Payload {
    private VastausJson[] vastaukset;

    public VastausJson[] getVastaukset() {
        return vastaukset;
    }

    public void setVastaukset(VastausJson[] vastaukset) {
        this.vastaukset = vastaukset;
    }
}
