package com.andreparelho.app.starwarschallenge.model.request;

import org.springframework.stereotype.Component;

@Component
public class PlanetModelRequest {
    private String name;
    private String climate;
    private String ground;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }
}
