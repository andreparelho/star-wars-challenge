package com.andreparelho.app.starwarschallenge.validator;

import com.andreparelho.app.starwarschallenge.http.api.StarWarsApi;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanetValidatorImpl implements PlanetValidator{
    private final StarWarsApi starWarsApi;
    private PlanetModelRequest validPlanet;
    @Autowired
    public PlanetValidatorImpl(StarWarsApi starWarsApi, PlanetModelRequest validPlanet) {
        this.starWarsApi = starWarsApi;
        this.validPlanet = validPlanet;
    }

    @Override
    public PlanetModelRequest validatePlanet(PlanetModelRequest planetModelRequest) {
        Map<String, Object> response = this.starWarsApi.getPlanets();
        List<Map<String, String>> planets = (List<Map<String, String>>) response.get("results");

        for (Map<String, String> planet : planets) {
            if (planet.get("name").equalsIgnoreCase(planetModelRequest.getName())) {
                this.validPlanet.setName(planet.get("name"));
                this.validPlanet.setClimate(planet.get("climate"));
                this.validPlanet.setGround(planet.get("terrain"));
                return this.validPlanet;
            }
        }

        return null;
    }
}
