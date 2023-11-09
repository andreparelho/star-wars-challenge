package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;

import java.util.List;

public interface PlanetService {
    PlanetModelResponse createPlanet(PlanetModelRequest planetModelRequest);
    List<PlanetEntity> listPlanets(PlanetModelRequest planetModelRequest);
    PlanetEntity getPlanetByName(String name);
    PlanetEntity getPlanetById(Long id);
    String deletePlanetByName(String name);
    String deletePlanetById(Long id);
}
