package com.andreparelho.app.starwarschallenge.controller;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;
import com.andreparelho.app.starwarschallenge.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StarWarsController {

    private final PlanetService planetService;

    @Autowired
    public StarWarsController(PlanetService planetService, PlanetModelResponse response) {
        this.planetService = planetService;
    }

    @PostMapping("/create-planet")
    public ResponseEntity<PlanetModelResponse> createPlanet(@RequestBody PlanetModelRequest planetModelRequest){
        PlanetModelResponse planet = this.planetService.createPlanet(planetModelRequest);
        if (planet != null){
            return ResponseEntity.ok(planet);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list-planets")
    public ResponseEntity<List<PlanetModelResponse>> listPlanets(){
        List<PlanetModelResponse> planets = this.planetService.listPlanets();
        return ResponseEntity.ok(planets);
    }

    @GetMapping("/get-planet-by-name")
    public ResponseEntity<Optional<PlanetModelResponse>> getPlanetByName(@RequestParam("name") String name){
        Optional<PlanetModelResponse> planetEntity = this.planetService.getPlanetByName(name);
        return ResponseEntity.ok(planetEntity);
    }

    @GetMapping("/get-planet-by-id")
    public ResponseEntity<Optional<PlanetModelResponse>> getPlanetById(@RequestParam("id") Long id){
        Optional<PlanetModelResponse> planet = this.planetService.getPlanetById(id);
        return ResponseEntity.ok(planet);
    }

    @DeleteMapping("/delete-planet-by-id")
    public ResponseEntity<PlanetModelResponse> deletePlanetById(@RequestParam("id") Long id){
        return ResponseEntity.ok().build();
    }
}
