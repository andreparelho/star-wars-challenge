package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;
import com.andreparelho.app.starwarschallenge.validator.PlanetValidator;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    private final PlanetValidator planetValidator;

    public PlanetService(PlanetModel planetModel, PlanetValidator planetValidator) {
        this.planetValidator = planetValidator;
    }

    public PlanetModelResponse createPlanet(PlanetModelRequest planetModelRequest){
        PlanetModelResponse planetResponse = new PlanetModelResponse();
        PlanetModelRequest validPlanet = this.planetValidator.validatePlanet(planetModelRequest);

        if (validPlanet != null){
            planetResponse.setName(validPlanet.getName());
            planetResponse.setClimate(validPlanet.getClimate());
            planetResponse.setGround(validPlanet.getGround());
            return planetResponse;
        }

        return null;
    }


}
