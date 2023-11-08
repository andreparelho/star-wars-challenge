package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.validator.PlanetValidator;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    private final PlanetValidator planetValidator;

    public PlanetService(PlanetModel planetModel, PlanetValidator planetValidator) {
        this.planetValidator = planetValidator;
    }

    public PlanetModel createPlanet(PlanetModelRequest planetModelRequest){
        PlanetModel newPlanet = new PlanetModel();
        PlanetModelRequest validPlanet = this.planetValidator.validatePlanet(planetModelRequest);

        if (validPlanet != null){
            newPlanet.setName(validPlanet.getName());
            newPlanet.setClimate(validPlanet.getClimate());
            newPlanet.setGround(validPlanet.getGround());
            return newPlanet;
        }

        return null;
    }


}
