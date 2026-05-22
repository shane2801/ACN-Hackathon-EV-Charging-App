package com.accenture.ev_charging_api.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String id;
    private String name;
    private List<Charger> chargers = new ArrayList<>();

    public Location(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Charger> getChargers() {
        return chargers;
    }

    public void addCharger(Charger charger) {
        chargers.add(charger);
    }
}