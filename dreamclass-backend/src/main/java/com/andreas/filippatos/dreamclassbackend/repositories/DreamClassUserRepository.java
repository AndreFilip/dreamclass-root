package com.andreas.filippatos.dreamclassbackend.repositories;

import com.andreas.filippatos.dreamclassbackend.entities.DreamClassUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DreamClassUserRepository extends JpaRepository<DreamClassUser, Long> {

    Optional<DreamClassUser> findByUsername(String username);

}
