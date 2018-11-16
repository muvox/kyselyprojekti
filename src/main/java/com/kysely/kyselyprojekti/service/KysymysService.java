package com.kysely.kyselyprojekti.service;

import com.kysely.kyselyprojekti.model.Kysymys;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KysymysService {

    Kysymys saveKysymys(Kysymys kysymys);

    Optional<Kysymys> readKysymysById(Long id);

    List<Kysymys> readAllKysymys();

    Kysymys updateKysymys(Kysymys kysymys);

    boolean deleteKysymys(Long id);
}
