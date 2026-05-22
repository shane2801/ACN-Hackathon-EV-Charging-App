package com.accenture.ev_charging_api.service;

import com.accenture.ev_charging_api.model.Charger;
import com.accenture.ev_charging_api.model.Location;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InfrastructureService {

    private final ConcurrentHashMap<String, Location> locations = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<String, Charger> chargers = new ConcurrentHashMap<>();

    // LOCATION METHODS

    public void createLocation(String id, String name) {
        locations.putIfAbsent(id, new Location(id, name));
    }

    public Collection<Location> getLocations() {
        return locations.values();
    }

    // CHARGER METHODS

    public void createCharger(String chargerId, String locationId) {

        Charger charger = new Charger(chargerId, locationId);

        chargers.put(chargerId, charger);

        Location location = locations.get(locationId);

        if (location != null) {
            location.addCharger(charger);
        }
    }

    public Charger getCharger(String chargerId) {
        return chargers.get(chargerId);
    }

    public Collection<Charger> getChargers() {
        return chargers.values();
    }
}