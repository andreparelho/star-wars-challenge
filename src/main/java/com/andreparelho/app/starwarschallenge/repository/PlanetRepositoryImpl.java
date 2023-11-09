package com.andreparelho.app.starwarschallenge.repository;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.repository.crud.CrudPlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetRepositoryImpl implements PlanetRepository{
    private final CrudPlanetRepository crudPlanetRepository;

    @Autowired
    public PlanetRepositoryImpl(CrudPlanetRepository crudPlanetRepository) {
        this.crudPlanetRepository = crudPlanetRepository;
    }

    @Override
    public PlanetEntity addPlanet(PlanetEntity planetEntity) {
        return this.crudPlanetRepository.save(planetEntity);
    }

    @Override
    public List<PlanetEntity> listPlanets() {
        return null;
    }

    @Override
    public PlanetEntity getPlanetByName(String name) {
        return null;
    }

    @Override
    public PlanetEntity getPlanetById(Long id) {
        return null;
    }

    @Override
    public String deletePlanetByName(String name) {
        return null;
    }

    @Override
    public String deletePlanetById(Long id) {
        return null;
    }
}
