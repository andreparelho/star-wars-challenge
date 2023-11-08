package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.validator.PlanetValidator;

public class PlanetService {
    private final PlanetValidator planetValidator;

    public PlanetService(PlanetModel planetModel, PlanetValidator planetValidator) {
        this.planetValidator = planetValidator;
    }

    public PlanetModel createPlanet(String name, String climate, String ground){
        PlanetModel newPlanet = new PlanetModel();
        boolean isValidPlanet = this.planetValidator.validatePlanet(newPlanet);

        if (isValidPlanet){
            newPlanet.setName(name);
            newPlanet.setClimate(climate);
            newPlanet.setGround(ground);
            return newPlanet;
        }

        return null;
    }
}
