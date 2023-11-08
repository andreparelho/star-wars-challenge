package com.andreparelho.app.starwarschallenge.repository.converter;

import com.andreparelho.app.starwarschallenge.entity.PlanetEntity;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;

public class PlanetConverter {

    public PlanetModel requestToModel(PlanetModelResponse planetModelResponse){
        PlanetModel model = new PlanetModel();
        model.setName(planetModelResponse.getName());
        model.setGround(planetModelResponse.getGround());
        model.setClimate(planetModelResponse.getClimate());
        return model;
    }

    public PlanetEntity modelToEntity(PlanetModel planetModel){
        PlanetEntity entity = new PlanetEntity();
        entity.setName(planetModel.getName());
        entity.setGround(planetModel.getGround());
        entity.setClimate(planetModel.getClimate());
        return entity;
    }
}
