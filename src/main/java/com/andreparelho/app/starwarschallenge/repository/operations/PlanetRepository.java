package com.andreparelho.app.starwarschallenge.repository.operations;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository <PlanetEntity, Long> {
}