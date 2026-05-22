package com.accenture.ev_charging_api.model;

public class Charger {

    private String chargerId;

    private String locationId;

    private String status;

    private boolean ocppConnected;

    private double powerKw;

    private double energyKwh;

    public Charger(String chargerId, String locationId) {
        this.chargerId = chargerId;
        this.locationId = locationId;
        this.status = "AVAILABLE";
        this.ocppConnected = false;
    }

    public String getChargerId() {
        return chargerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getStatus() {
        return status;
    }

    public boolean isOcppConnected() {
        return ocppConnected;
    }

    public double getPowerKw() {
        return powerKw;
    }

    public double getEnergyKwh() {
        return energyKwh;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOcppConnected(boolean ocppConnected) {
        this.ocppConnected = ocppConnected;
    }

    public void setPowerKw(double powerKw) {
        this.powerKw = powerKw;
    }

    public void setEnergyKwh(double energyKwh) {
        this.energyKwh = energyKwh;
    }
}