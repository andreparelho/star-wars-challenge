package com.andreparelho.app.starwarschallenge.repository;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository {
    PlanetEntity addPlanet(PlanetEntity planetEntity);
    List<PlanetEntity> listPlanets();
    Optional<PlanetEntity> getPlanetByName(String name);
    Optional<PlanetEntity> getPlanetById(Long id);
    String deletePlanetById(Long id);
}
