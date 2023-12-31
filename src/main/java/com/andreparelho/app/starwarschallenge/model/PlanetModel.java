package com.andreparelho.app.starwarschallenge.model;

import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import org.springframework.stereotype.Component;

@Component
public class PlanetModel {
    private String name;
    private String climate;
    private String ground;
    private int movies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public int getMovies() {
        return movies;
    }

    public void setMovies(int movies) {
        this.movies = movies;
    }

    public PlanetModel createModel(PlanetModelRequest planetModelRequest){
        PlanetModel planetModel = new PlanetModel();
        planetModel.setName(planetModelRequest.getName());
        planetModel.setClimate(planetModelRequest.getClimate());
        planetModel.setGround(planetModelRequest.getGround());
        planetModel.setMovies(planetModelRequest.getMovies());
        return planetModel;
    }
}
