package com.example.demo.services.impl;

import com.example.demo.dtos.HealthCheckDto;
import com.example.demo.models.HealthCheck;
import com.example.demo.services.HealthService;
import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class HealthServiceImpl implements HealthService {

    @Override
    public HealthCheck healthCheck() {
        HealthCheck aliveServer = 
            new HealthCheck()
                .builder()
                .message("OK")
                .description("App is alive")
                .build();

        return aliveServer;
    }

    @Override
    public HealthCheck healthCheckById(UUID id) {
        HealthCheck aliveServer = 
            new HealthCheck()
                .builder()
                .id(id)
                .message("OK")
                .description("App is alive with ID: ${id}")
                .build();

        return aliveServer;
    }

    @Override
    public HealthCheck deleteHealthCheckById(UUID id) {
        HealthCheck deletedServer = 
            new HealthCheck()
                .builder()
                .id(id)
                .message("DELETED")
                .description("App health check with ID: ${id} has been deleted")
                .build();

        return deletedServer;
    }

    @Override
    public HealthCheck createHealthCheck(HealthCheckDto healthCheckDto) {
        HealthCheck newServer = 
            new HealthCheck()
                .builder()
                .id(UUID.randomUUID())
                .message(healthCheckDto.getMessage())
                .description(healthCheckDto.getDescription())
                .build();

        return newServer;
    }

}
