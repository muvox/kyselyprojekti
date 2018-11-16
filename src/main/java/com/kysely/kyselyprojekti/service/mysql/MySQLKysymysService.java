package com.kysely.kyselyprojekti.service.mysql;

import com.kysely.kyselyprojekti.model.Kysymys;
import com.kysely.kyselyprojekti.repository.KysymysRepository;
import com.kysely.kyselyprojekti.service.KyselyService;
import com.kysely.kyselyprojekti.service.KysymysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MySQLKysymysService implements KysymysService {

    private static final Logger log = LoggerFactory.getLogger(KyselyService.class);

    @Autowired
    KysymysRepository repository;


    @Override
    public Kysymys saveKysymys(Kysymys kysymys) {
        return repository.save(kysymys);
    }

    @Override
    public Optional<Kysymys> readKysymysById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Kysymys> readAllKysymys() {
        return (List<Kysymys>) repository.findAll();
    }

    @Override
    public Kysymys updateKysymys(Kysymys kysymys) {
        if (!repository.existsById(kysymys.getId())) {
            log.error("Kysely with id: {} doesn't exist", kysymys.getId());
            return null;
        }
        return repository.save(kysymys);
    }

    @Override

    public boolean deleteKysymys(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        log.error("Kysymys with id:" + id + "doesn't exist");
        return false;
    }
}




