package com.kysely.kyselyprojekti.repository;

import com.kysely.kyselyprojekti.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

        User findByUsername(String username);
    }
