package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.validator.PlanetValidator;

public class PlanetService {
    private final PlanetValidator planetValidator;

    public PlanetService(PlanetModel planetModel, PlanetValidator planetValidator) {
        this.planetValidator = planetValidator;
    }

    public PlanetModel createPlanet(PlanetModelRequest planetModelRequest){
        PlanetModel newPlanet = new PlanetModel();
        boolean isValidPlanet = this.planetValidator.validatePlanet(newPlanet);

        if (isValidPlanet){
            newPlanet.setName(planetModelRequest.getName());
            newPlanet.setClimate(planetModelRequest.getClimate());
            newPlanet.setGround(planetModelRequest.getGround());
            return newPlanet;
        }

        return null;
    }
}
