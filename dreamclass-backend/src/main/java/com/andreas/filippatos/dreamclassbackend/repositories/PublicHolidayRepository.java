package com.andreas.filippatos.dreamclassbackend.repositories;

import com.andreas.filippatos.dreamclassbackend.entities.PublicHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicHolidayRepository extends JpaRepository<PublicHoliday, Long> {
}