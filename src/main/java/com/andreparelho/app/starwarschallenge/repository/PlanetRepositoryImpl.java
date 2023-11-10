package com.andreparelho.app.starwarschallenge.repository;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.repository.crud.CrudPlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return (List<PlanetEntity>) this.crudPlanetRepository.findAll();
    }

    @Override
    public Optional<PlanetEntity> getPlanetByName(String name) {
        return this.crudPlanetRepository.getByName(name);
    }

    @Override
    public Optional<PlanetEntity> getPlanetById(Long id) {
        return this.crudPlanetRepository.findById(id);
    }

    @Override
    public Optional<String> deletePlanetById(Long id) {
        this.crudPlanetRepository.deleteById(id);
        Optional<String> response = Optional.of("planeta deletado com sucesso.");
        return response;
    }
}
