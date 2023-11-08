package com.andreparelho.app.starwarschallenge.validator;

import com.andreparelho.app.starwarschallenge.http.api.StarWarsApi;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;

import java.util.List;

public class PlanetValidatorImpl implements PlanetValidator{
    private final StarWarsApi starWarsApi;
    private PlanetModel planetModel;

    public PlanetValidatorImpl(StarWarsApi starWarsApi, PlanetModel planetModel) {
        this.starWarsApi = starWarsApi;
        this.planetModel = planetModel;
    }

    @Override
    public boolean validatePlanet(PlanetModel planetModel) {
        List<PlanetModel> planets = (List<PlanetModel>) starWarsApi.getPlanets();
        boolean isValidPlanet = false;
        for (PlanetModel planet : planets) {
            if (planetModel.getName().equalsIgnoreCase(planet.getName())){
                isValidPlanet = true;
                break;
            }
        }
        return isValidPlanet;
    }
}
