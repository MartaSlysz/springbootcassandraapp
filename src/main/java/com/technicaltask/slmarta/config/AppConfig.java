package com.technicaltask.slmarta.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${spring.data.cassandra.keyspace:placeholder}")
    private String keySpace;

    @Bean
    public CqlSession session() {
        return CqlSession.builder().withKeyspace(keySpace).build();
    }

}
