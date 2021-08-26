package com.andreas.filippatos.dreamclassbackend.repositories;

import com.andreas.filippatos.dreamclassbackend.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
