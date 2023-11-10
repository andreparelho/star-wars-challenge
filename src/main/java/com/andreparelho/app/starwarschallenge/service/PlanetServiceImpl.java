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
import java.util.Optional;


@Service
public class PlanetServiceImpl implements PlanetService {
    private final PlanetValidator planetValidator;
    private final PlanetRepository planetRepository;
    private final PlanetConverter planetConverter;
    private PlanetModel planetModel;
    private PlanetModelResponse planetModelResponse;
    @Autowired
    public PlanetServiceImpl(PlanetValidator planetValidator, PlanetRepository planetRepository, PlanetConverter planetConverter, PlanetModel planetModel, PlanetModelResponse planetModelResponse) {
        this.planetValidator = planetValidator;
        this.planetRepository = planetRepository;
        this.planetConverter = planetConverter;
        this.planetModel = planetModel;
        this.planetModelResponse = planetModelResponse;
    }

    @Override
    public PlanetModelResponse createPlanet(PlanetModelRequest planetModelRequest){
        PlanetModelRequest validPlanet = this.planetValidator.validatePlanet(planetModelRequest);

        if (validPlanet != null){
            PlanetEntity planetEntity = this.planetConverter.modelToEntity(this.planetModel.createModel(validPlanet));
            this.planetRepository.addPlanet(planetEntity);

            return this.planetModelResponse.createResponse(validPlanet);
        }

        return null;
    }

    @Override
    public List<PlanetModelResponse> listPlanets() {
        List<PlanetEntity> planetEntityList = this.planetRepository.listPlanets();

        List<PlanetModelResponse> response = this.planetConverter.entityListToResponseList(planetEntityList);
        return response;
    }

    @Override
    public  Optional<PlanetModelResponse> getPlanetByName(String name) {
        Optional<PlanetEntity> planetEntityOptional = this.planetRepository.getPlanetByName(name);
        return Optional.ofNullable(this.planetConverter.optionalToResponse(planetEntityOptional));
    }

    @Override
    public Optional<PlanetModelResponse> getPlanetById(Long id) {
        Optional<PlanetEntity> planetEntityOptional = this.planetRepository.getPlanetById(id);
        return Optional.ofNullable(this.planetConverter.optionalToResponse(planetEntityOptional));
    }

    @Override
    public Optional<String> deletePlanetById(Long id) {
        return this.planetRepository.deletePlanetById(id);
    }
}
