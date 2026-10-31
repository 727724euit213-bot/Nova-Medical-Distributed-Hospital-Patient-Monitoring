package com.hospital.monitoring.controller;

import com.hospital.monitoring.model.*;
import com.hospital.monitoring.service.MonitoringService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:5173")
public class MonitoringController {
    private final MonitoringService service;
    public MonitoringController(MonitoringService service){this.service=service;}

    @GetMapping("/patients") public List<Patient> patients(){return service.patients();}
    @GetMapping("/alerts") public List<Alert> alerts(){return service.alerts();}
    @GetMapping("/patients/{id}/history") public List<VitalReading> history(@PathVariable Long id){return service.history(id);}
    @PostMapping("/vitals") public VitalReading vitals(@RequestBody VitalReading v){return service.ingest(v);}
    @PostMapping("/seed") public String seed(){service.seed();return "Demo data initialized";}
}