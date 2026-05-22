package com.accenture.ev_charging_api.config;

import com.accenture.ev_charging_api.service.InfrastructureService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final InfrastructureService infrastructureService;

    public DataLoader(InfrastructureService infrastructureService) {
        this.infrastructureService = infrastructureService;
    }

    @PostConstruct
    public void loadData() {

        // LOCATIONS
        infrastructureService.createLocation("nex-tower", "Nex Tower");

        infrastructureService.createLocation("nexteracom", "Nexteracom");

        // CHARGERS
        infrastructureService.createCharger("charger-001", "nex-tower");

        infrastructureService.createCharger("charger-002", "nex-tower");

        infrastructureService.createCharger("charger-101", "nexteracom");
    }
}