package com.kysely.kyselyprojekti.domain;

import com.kysely.kyselyprojekti.model.Kysymys;
import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {
}
