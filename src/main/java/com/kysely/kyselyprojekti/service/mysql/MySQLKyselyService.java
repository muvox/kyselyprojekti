package com.kysely.kyselyprojekti.service.mysql;

import com.kysely.kyselyprojekti.domain.KyselyRepository;
import com.kysely.kyselyprojekti.model.Kysely;
import com.kysely.kyselyprojekti.service.KyselyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MySQLKyselyService implements KyselyService {

    private static final Logger log = LoggerFactory.getLogger(KyselyService.class);

    @Autowired
    private KyselyRepository repository;


    @Override
    public Kysely createKysely(Kysely kysely){
        return repository.save(kysely);
    }

    @Override
    public Optional<Kysely> readKysely(Long id){
        return repository.findById(id);
    }

    @Override
    public List<Kysely> readAllKysely(){
        return (List<Kysely>) repository.findAll();
    }

    @Override
    public Kysely updateKysely(Kysely kysely){
        if(!repository.existsById(kysely.getId())) {
            log.error("Kysely with id: {} doesn't exist", kysely.getId());
            return null;
        }
        return repository.save(kysely);
    }

    @Override
    public boolean deleteKysely(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        log.error("Kysely with id:" + id + "doesn't exist");
        return false;
    }
}
