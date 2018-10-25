package com.kysely.kyselyprojekti.domain;

import com.kysely.kyselyprojekti.model.Kysely;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by a1704471 on 25.10.2018.
 */
public interface KyselyRepository extends CrudRepository<Kysely, Long>{
    List<Kysely> findById(int id);
}
