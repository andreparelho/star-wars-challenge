package com.andreparelho.app.starwarschallenge.http.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "star-wars-api", url = "${integration.star-wars-api.url}")
public interface StarWarsApi {

    @GetMapping("/planets/")
    Map<String, Object> getPlanets();

    @GetMapping("/planets/{planetId}")
    Map<String, Object> getPlanet(@PathVariable("planetId") String planetId);
}
