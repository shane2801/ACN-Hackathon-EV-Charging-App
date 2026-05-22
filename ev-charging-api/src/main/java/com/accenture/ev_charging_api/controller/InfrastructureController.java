package com.accenture.ev_charging_api.controller;

import com.accenture.ev_charging_api.service.InfrastructureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/infrastructure")
public class InfrastructureController {

    private final InfrastructureService infrastructureService;

    public InfrastructureController(InfrastructureService infrastructureService) {
        this.infrastructureService = infrastructureService;
    }

    @GetMapping("/locations")
    public Object getLocations() {
        return infrastructureService.getLocations();
    }

    @GetMapping("/chargers")
    public Object getChargers() {
        return infrastructureService.getChargers();
    }
}