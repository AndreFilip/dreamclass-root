package com.andreas.filippatos.dreamclassbackend.configurations;

import com.andreas.filippatos.dreamclassbackend.entities.PublicHoliday;
import com.andreas.filippatos.dreamclassbackend.repositories.PublicHolidayRepository;
import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PublicHolidayRepository repository) {
        return args -> {
            repository.save(PublicHoliday.builder().date("2020-07-22").description("Public holiday from backend 1").build());
            repository.save(PublicHoliday.builder().date("2020-07-23").description("Public holiday from backend 2").build());
            repository.save(PublicHoliday.builder().date("2020-07-24").description("Public holiday from backend 3").build());
            repository.save(PublicHoliday.builder().date("2021-07-24").description("Public holiday from backend 4").build());
            repository.save(PublicHoliday.builder().date("2020-08-24").description("Public holiday from backend 5").build());
            repository.save(PublicHoliday.builder().date("2020-09-24").description("Public holiday from backend 6").build());
            repository.save(PublicHoliday.builder().date("2020-03-24").description("Public holiday from backend 7").build());
            repository.save(PublicHoliday.builder().date("2020-01-24").description("Public holiday from backend 8").build());
            repository.save(PublicHoliday.builder().date("2020-02-24").description("Public holiday from backend 9").build());
            repository.save(PublicHoliday.builder().date("2019-07-24").description("Public holiday from backend 10").build());
            repository.save(PublicHoliday.builder().date("2018-07-24").description("Public holiday from backend 11").build());
            repository.save(PublicHoliday.builder().date("2017-07-24").description("Public holiday from backend 12").build());
            repository.save(PublicHoliday.builder().date("2016-07-24").description("Public holiday from backend 13").build());
            repository.save(PublicHoliday.builder().date("2015-07-24").description("Public holiday from backend 14").build());
            repository.save(PublicHoliday.builder().date("2014-07-24").description("Public holiday from backend 15").build());
            repository.save(PublicHoliday.builder().date("2013-07-24").description("Public holiday from backend 16").build());
            repository.save(PublicHoliday.builder().date("2012-07-24").description("Public holiday from backend 17").build());
            repository.save(PublicHoliday.builder().date("2011-07-24").description("Public holiday from backend 18").build());
            repository.save(PublicHoliday.builder().date("2010-07-24").description("Public holiday from backend 19").build());
            repository.save(PublicHoliday.builder().date("2009-07-24").description("Public holiday from backend 20").build());
            repository.save(PublicHoliday.builder().date("2008-07-24").description("Public holiday from backend 21").build());
            repository.save(PublicHoliday.builder().date("2007-07-24").description("Public holiday from backend 22").build());
            repository.save(PublicHoliday.builder().date("2006-07-24").description("Public holiday from backend 23").build());
            repository.save(PublicHoliday.builder().date("2005-07-24").description("Public holiday from backend 24").build());
            repository.save(PublicHoliday.builder().date("2004-07-24").description("Public holiday from backend 25").build());
            repository.save(PublicHoliday.builder().date("2003-07-24").description("Public holiday from backend 26").build());
            repository.save(PublicHoliday.builder().date("2002-07-24").description("Public holiday from backend 27").build());
            repository.save(PublicHoliday.builder().date("2001-07-24").description("Public holiday from backend 28").build());
            repository.save(PublicHoliday.builder().date("2000-07-24").description("Public holiday from backend 29").build());
            repository.save(PublicHoliday.builder().date("1999-07-24").description("Public holiday from backend 30").build());
            repository.save(PublicHoliday.builder().date("1998-07-24").description("Public holiday from backend 31").build());
            repository.save(PublicHoliday.builder().date("1997-07-24").description("Public holiday from backend 32").build());
            repository.save(PublicHoliday.builder().date("1996-07-24").description("Public holiday from backend 33").build());
        };
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
