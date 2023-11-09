package com.andreparelho.app.starwarschallenge.service;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;
import com.andreparelho.app.starwarschallenge.repository.PlanetRepository;
import com.andreparelho.app.starwarschallenge.repository.converter.PlanetConverter;
import com.andreparelho.app.starwarschallenge.validator.PlanetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanetServiceImpl implements PlanetService {
    private final PlanetValidator planetValidator;
    private final PlanetRepository planetRepository;
    private final PlanetConverter planetConverter;
    @Autowired
    public PlanetServiceImpl(PlanetValidator planetValidator, PlanetRepository planetRepository, PlanetConverter planetConverter) {
        this.planetValidator = planetValidator;
        this.planetRepository = planetRepository;
        this.planetConverter = planetConverter;
    }

    @Override
    public PlanetModelResponse createPlanet(PlanetModelRequest planetModelRequest){
        PlanetModelResponse planetResponse = new PlanetModelResponse();
        PlanetModelRequest validPlanet = this.planetValidator.validatePlanet(planetModelRequest);

        if (validPlanet != null){
            PlanetModel planetModel = this.planetConverter.requestToModel(planetModelRequest);
            planetModel.setName(validPlanet.getName());
            planetModel.setClimate(validPlanet.getClimate());
            planetModel.setGround(validPlanet.getGround());

            PlanetEntity planetEntity = this.planetConverter.modelToEntity(planetModel);
            this.planetRepository.addPlanet(planetEntity);

            planetResponse.setName(validPlanet.getName());
            planetResponse.setClimate(validPlanet.getClimate());
            planetResponse.setGround(validPlanet.getGround());
            planetResponse.setMovies(validPlanet.getMovies());
            return planetResponse;
        }

        return null;
    }

    @Override
    public List<PlanetEntity> listPlanets(PlanetModelRequest planetModelRequest) {
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
