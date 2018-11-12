package com.kysely.kyselyprojekti.service;

import com.kysely.kyselyprojekti.model.Kysely;

import java.util.List;

public interface KyselyService {

    Kysely createKysely(Kysely kysely);

    Kysely readKysely(Long id);

    List<Kysely> readAllKysely();

    Kysely updateKysely(Kysely kysely);

    boolean deleteKysely(Long id);

}
