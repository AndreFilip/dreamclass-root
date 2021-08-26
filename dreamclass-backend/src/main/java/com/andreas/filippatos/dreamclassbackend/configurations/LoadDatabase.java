package com.andreas.filippatos.dreamclassbackend.configurations;

import com.andreas.filippatos.dreamclassbackend.entities.*;
import com.andreas.filippatos.dreamclassbackend.repositories.*;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;
import java.util.*;

@Configuration
public class LoadDatabase {

    @Autowired
    private DreamClassUserRepository dreamClassUserRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(PublicHolidayRepository repository) {
        return args -> {
            repository.save(PublicHoliday.builder().date("2020-07-22").description("Public holiday from backend 1").build());
            repository.save(PublicHoliday.builder().date("2020-07-23").description("Public holiday from backend 2").build());
            repository.save(PublicHoliday.builder().date("2020-07-24").description("Public holiday from backend 3").build());

            Authority userRole = authorityRepository.save(Authority.builder().role("USER").build());
            Authority admin = authorityRepository.save(Authority.builder().role("ADMIN").build());

            dreamClassUserRepository.save(DreamClassUser.builder().username("username1").password(passwordEncoder.encode("username1")).authority(userRole).build());
            dreamClassUserRepository.save(DreamClassUser.builder().username("admin1").password(passwordEncoder.encode("admin1")).authority(admin).build());
        };
    }

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server h2Server() throws SQLException {
//        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//    }
}