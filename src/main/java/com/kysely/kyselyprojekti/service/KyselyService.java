package com.kysely.kyselyprojekti.service;

import com.kysely.kyselyprojekti.model.Kysely;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KyselyService {

    Kysely createKysely(Kysely kysely);

    Optional<Kysely> readKysely(Long id);

    List<Kysely> readAllKysely();

    Kysely updateKysely(Kysely kysely);

    boolean deleteKysely(Long id);

}
