package com.andreparelho.app.starwarschallenge.repository.converter;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlanetConverter {
    public PlanetModel requestToModel(PlanetModelRequest planetModelRequest){
        PlanetModel model = new PlanetModel();
        model.setName(planetModelRequest.getName());
        model.setGround(planetModelRequest.getGround());
        model.setClimate(planetModelRequest.getClimate());
        model.setMovies(planetModelRequest.getMovies());
        return model;
    }

    public PlanetEntity modelToEntity(PlanetModel planetModel){
        PlanetEntity entity = new PlanetEntity();
        entity.setName(planetModel.getName());
        entity.setGround(planetModel.getGround());
        entity.setClimate(planetModel.getClimate());
        entity.setMovies(planetModel.getMovies());
        return entity;
    }

    public PlanetModelResponse entityToResponse(PlanetEntity planetEntity){
        PlanetModelResponse response = new PlanetModelResponse();
        response.setName(planetEntity.getName());
        response.setGround(planetEntity.getGround());
        response.setClimate(planetEntity.getClimate());
        response.setMoviesAppearances(planetEntity.getMovies());
        return response;
    }

    public List<PlanetModelResponse> entityListToResponseList(List<PlanetEntity> planetEntity){
        List<PlanetModelResponse> planetsList = new ArrayList<>();

        for (PlanetEntity planet : planetEntity) {
            PlanetModelResponse planetModelResponse = new PlanetModelResponse();
            planetModelResponse.setName(planet.getName());
            planetModelResponse.setGround(planet.getGround());
            planetModelResponse.setClimate(planet.getClimate());
            planetModelResponse.setMoviesAppearances(planet.getMovies());
            planetsList.add(planetModelResponse);
        }

        return planetsList;
    }

    public PlanetModelResponse requestToResponse(PlanetModelRequest planetModelRequest){
        PlanetModelResponse response = new PlanetModelResponse();
        response.setName(planetModelRequest.getName());
        response.setGround(planetModelRequest.getGround());
        response.setClimate(planetModelRequest.getClimate());
        response.setMoviesAppearances(planetModelRequest.getMovies());
        return response;
    }

    public PlanetModelResponse optionalToResponse(Optional<PlanetEntity> planetEntityOptional){
        PlanetModelResponse response = new PlanetModelResponse();
        response.setName(planetEntityOptional.get().getName());
        response.setGround(planetEntityOptional.get().getGround());
        response.setClimate(planetEntityOptional.get().getClimate());
        response.setMoviesAppearances(planetEntityOptional.get().getMovies());
        return response;
    }
}
