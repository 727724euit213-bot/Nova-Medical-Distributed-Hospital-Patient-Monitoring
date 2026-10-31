package com.hospital.monitoring.config;
import com.hospital.monitoring.service.MonitoringService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataInitializer {
    @Bean CommandLineRunner init(MonitoringService service){return args -> service.seed();}
}