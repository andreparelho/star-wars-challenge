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
    private PlanetModelRequest planetModelRequest;
    @Autowired
    public PlanetValidatorImpl(StarWarsApi starWarsApi, PlanetModelRequest validPlanet) {
        this.starWarsApi = starWarsApi;
        this.planetModelRequest = validPlanet;
    }

    @Override
    public PlanetModelRequest validatePlanet(PlanetModelRequest planetModelRequest) {
        Map<String, Object> response = this.starWarsApi.getPlanets();
        List<Map<String, String>> planets = (List<Map<String, String>>) response.get("results");

        for (Map<String, String> planet : planets) {
            String responseApiPlanetName = planet.get("name");
            String responseApiPlanetClimate = planet.get("climate");
            String responseApiPlanetTerrain = planet.get("terrain");
            if (responseApiPlanetName.equalsIgnoreCase(planetModelRequest.getName())) {
                this.planetModelRequest.setName(responseApiPlanetName);
                this.planetModelRequest.setClimate(responseApiPlanetClimate);
                this.planetModelRequest.setGround(responseApiPlanetTerrain);

                String responseApiPlanetUrl = getFilmId(planet.get("url"));
                int filmNumbers = getNumbersFilmById(responseApiPlanetUrl);
                this.planetModelRequest.setMovies(filmNumbers);

                return this.planetModelRequest;
            }
        }

        return null;
    }

    private String getFilmId (String url){
        Pattern pattern = Pattern.compile("/(\\d+)/");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()){
            String idFilm = matcher.group(1);
            return idFilm;
        }

        return null;
    }

    private int getNumbersFilmById(String film){
        Map<String, Object> response = this.starWarsApi.getPlanet(film);
        List<String> responseApiPlanetFilms =  (List<String>) response.get("films");
        return responseApiPlanetFilms.size();
    }
}
