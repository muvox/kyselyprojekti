package com.kysely.kyselyprojekti.repository;

import com.kysely.kyselyprojekti.model.Vastaus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VastausRepository extends CrudRepository<Vastaus, Long> {
}