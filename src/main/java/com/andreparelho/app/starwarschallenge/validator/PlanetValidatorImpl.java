package com.andreparelho.app.starwarschallenge.validator;

import com.andreparelho.app.starwarschallenge.http.api.StarWarsApi;
import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanetValidatorImpl implements PlanetValidator{
    private final StarWarsApi starWarsApi;

    public PlanetValidatorImpl(StarWarsApi starWarsApi, PlanetModel planetModel) {
        this.starWarsApi = starWarsApi;
    }

    @Override
    public boolean validatePlanet(PlanetModelRequest planetModelRequest) {
        Map<String, Object> response = starWarsApi.getPlanets();
        List<Map<String, String>> results = (List<Map<String, String>>) response.get("results");

        boolean isValidPlanet = false;
        for (Map<String, String> planet : results) {
            if (planet.get("name").equalsIgnoreCase(planetModelRequest.getName())) {
                isValidPlanet = true;
                break;
            }
        }
        return isValidPlanet;
    }
}
