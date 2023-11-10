package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;

import java.util.List;
import java.util.Optional;

public interface PlanetService {
    PlanetModelResponse createPlanet(PlanetModelRequest planetModelRequest);
    List<PlanetModelResponse> listPlanets();
    Optional<PlanetModelResponse> getPlanetByName(String name);
    Optional<PlanetModelResponse> getPlanetById(Long id);
    String deletePlanetById(Long id);
}
