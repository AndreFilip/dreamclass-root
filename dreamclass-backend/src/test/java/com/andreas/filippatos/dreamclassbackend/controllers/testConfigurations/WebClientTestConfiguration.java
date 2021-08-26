package com.andreas.filippatos.dreamclassbackend.controllers.testConfigurations;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;

import java.sql.SQLException;

@TestConfiguration
public class WebClientTestConfiguration {

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server h2Server() throws SQLException {
//        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9091");
//    }
}
