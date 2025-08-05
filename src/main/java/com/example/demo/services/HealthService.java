package com.example.demo.services;

import java.util.UUID;

import com.example.demo.dtos.HealthCheckDto;
import com.example.demo.models.HealthCheck;

public interface HealthService {

    HealthCheck healthCheck();
    HealthCheck healthCheckById(UUID id);
    HealthCheck deleteHealthCheckById(UUID id);
    HealthCheck createHealthCheck(HealthCheckDto healthCheckDto);

}
