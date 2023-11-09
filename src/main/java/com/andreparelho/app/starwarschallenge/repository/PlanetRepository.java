package com.andreparelho.app.starwarschallenge.repository;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;

import java.util.List;

public interface PlanetRepository {
    PlanetEntity createPlanet(PlanetEntity planetEntity);
    List<PlanetEntity> listPlanets();
    PlanetEntity getPlanetByName(String name);
    PlanetEntity getPlanetById(Long id);
    String deletePlanetByName(String name);
    String deletePlanetById(Long id);
}
