package com.kysely.kyselyprojekti.service;

import com.kysely.kyselyprojekti.model.Kysymys;

import java.util.List;

public interface KysymysService {

    Kysymys createKysymys(Kysymys kysymys);

    Kysymys readKysymysById(Long id);

    List<Kysymys> readAllKysymys();

    Kysymys updateKysymys(Kysymys kysymys);

    boolean deleteKysymys(Long id);
}
