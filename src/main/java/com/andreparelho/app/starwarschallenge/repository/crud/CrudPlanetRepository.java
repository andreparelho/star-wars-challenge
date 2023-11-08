package com.andreparelho.app.starwarschallenge.repository.crud;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudPlanetRepository extends CrudRepository <PlanetEntity, Long> {
}
