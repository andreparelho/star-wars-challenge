package com.andreparelho.app.starwarschallenge.validator;

import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;

public interface PlanetValidator {
    PlanetModelRequest validatePlanet(PlanetModelRequest planetModelRequest);
}
