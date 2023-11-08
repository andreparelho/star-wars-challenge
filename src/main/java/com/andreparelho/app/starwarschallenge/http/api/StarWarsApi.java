package com.andreparelho.app.starwarschallenge.http.api;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "star-wars-api", url = "${integration.star-wars-api.url}")
public interface StarWarsApi {

    @GetMapping("/api/planets/")
    PlanetModel getPlanets();
}
