package com.andreparelho.app.starwarschallenge.validator;

import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;

public interface PlanetValidator {
    boolean validatePlanet(PlanetModelRequest planetModelRequest);
}
