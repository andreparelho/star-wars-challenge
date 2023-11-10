package com.andreparelho.app.starwarschallenge.validator;

import com.andreparelho.app.starwarschallenge.http.api.StarWarsApi;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            String responseApiPlanetName = planet.get("name");
            if (responseApiPlanetName.equalsIgnoreCase(planetModelRequest.getName())) {
                this.validPlanet.setName(responseApiPlanetName);
                this.validPlanet.setClimate(planet.get("climate"));
                this.validPlanet.setGround(planet.get("terrain"));

                String numberFilmUrl = getNumberFilmUrl(planet.get("url"));
                int filmNumber = getFilmNumber(numberFilmUrl);
                this.validPlanet.setMovies(filmNumber);

                return this.validPlanet;
            }
        }

        return null;
    }

    private String getNumberFilmUrl (String url){
        Pattern pattern = Pattern.compile("/(\\d+)/");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()){
            return matcher.group(1);
        }

        return null;
    }

    private int getFilmNumber(String film){
        Map<String, Object> response = this.starWarsApi.getPlanet(film);
        List<String> movies = (List<String>) response.get("films");
        return movies.size();
    }
}
