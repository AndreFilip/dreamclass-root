package com.andreas.filippatos.dreamclassbackend.services;

import com.andreas.filippatos.dreamclassbackend.entities.PublicHoliday;
import com.andreas.filippatos.dreamclassbackend.repositories.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicHolidayService {

    @Autowired
    private PublicHolidayRepository publicHolidayRepository;

    public List<PublicHoliday> getAllPublicHolidays() {
        return publicHolidayRepository.findAll();
    }

    public PublicHoliday save(PublicHoliday publicHoliday) {
        return publicHolidayRepository.save(publicHoliday);
    }

    public void delete(Long id) {
        publicHolidayRepository.delete(publicHolidayRepository.getById(id));
    }

    public void deleteAllById(List<Long> ids) {
        publicHolidayRepository.deleteAllById(ids);
    }
}
