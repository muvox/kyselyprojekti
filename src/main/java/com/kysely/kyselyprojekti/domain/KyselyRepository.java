package com.kysely.kyselyprojekti.domain;

import com.kysely.kyselyprojekti.model.Kysely;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by a1704471 on 25.10.2018.
 */
@Repository
public interface KyselyRepository extends CrudRepository<Kysely, Long>{
    List<Kysely> findAll();
}
