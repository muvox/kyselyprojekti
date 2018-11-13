package com.kysely.kyselyprojekti.service;

import com.kysely.kyselyprojekti.model.Kysely;

import java.util.List;
import java.util.Optional;

public interface KyselyService {

    Kysely createKysely(Kysely kysely);

    Optional<Kysely> readKysely(Long id);

    List<Kysely> readAllKysely();

    Kysely updateKysely(Kysely kysely);

    boolean deleteKysely(Long id);

}
