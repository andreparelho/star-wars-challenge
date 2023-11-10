package com.andreparelho.app.starwarschallenge.model.response;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class PlanetModelResponse {
    private String name;
    private String climate;
    private String ground;
    @JsonProperty("movie_appearances")
    private int moviesAppearances;

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

    public int getMoviesAppearances() {
        return moviesAppearances;
    }

    public void setMoviesAppearances(int moviesAppearances) {
        this.moviesAppearances = moviesAppearances;
    }

    public PlanetModelResponse createResponse(PlanetModelRequest planetModelRequest){
        PlanetModelResponse planetResponse = new PlanetModelResponse();
        planetResponse.setName(planetModelRequest.getName());
        planetResponse.setClimate(planetModelRequest.getClimate());
        planetResponse.setGround(planetModelRequest.getGround());
        planetResponse.setMoviesAppearances(planetModelRequest.getMovies());
        return planetResponse;
    }
}
