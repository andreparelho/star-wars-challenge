package com.andreparelho.app.starwarschallenge.repository.converter;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;
import org.springframework.stereotype.Component;

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

    public PlanetModelResponse requestToResponse(PlanetModelRequest planetModelRequest){
        PlanetModelResponse response = new PlanetModelResponse();
        response.setName(planetModelRequest.getName());
        response.setGround(planetModelRequest.getGround());
        response.setClimate(planetModelRequest.getClimate());
        response.setMovies(planetModelRequest.getMovies());
        return response;
    }
}
