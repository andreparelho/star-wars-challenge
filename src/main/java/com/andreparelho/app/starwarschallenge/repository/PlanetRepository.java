package com.andreparelho.app.starwarschallenge.repository;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlanetRepository {
    PlanetEntity addPlanet(PlanetEntity planetEntity);
    List<PlanetEntity> listPlanets();
    PlanetEntity getPlanetByName(String name);
    PlanetEntity getPlanetById(Long id);
    String deletePlanetByName(String name);
    String deletePlanetById(Long id);
}
