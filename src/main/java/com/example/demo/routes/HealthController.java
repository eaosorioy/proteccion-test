package com.example.demo.routes;

import com.example.demo.dtos.HealthCheckDto;
import com.example.demo.models.HealthCheck;
import com.example.demo.services.HealthService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthController {
    private final HealthService healthService;

    @GetMapping
    public ResponseEntity<HealthCheck> healthCheck() {
        return new ResponseEntity<>(healthService.healthCheck(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthCheck> healthCheckById(
        @PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(healthService.healthCheckById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HealthCheck> deleteHealthCheckById(
        @PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(healthService.deleteHealthCheckById(id), HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<HealthCheck> createHealthCheck(
        @RequestBody HealthCheckDto healthCheckDto
    ) {
        return new ResponseEntity<>(healthService.createHealthCheck(healthCheckDto), HttpStatus.CREATED);
    }

}
