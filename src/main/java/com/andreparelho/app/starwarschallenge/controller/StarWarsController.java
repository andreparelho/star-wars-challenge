package com.andreparelho.app.starwarschallenge.controller;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.model.request.PlanetModelRequest;
import com.andreparelho.app.starwarschallenge.model.response.PlanetModelResponse;
import com.andreparelho.app.starwarschallenge.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarWarsController {

    private final PlanetService planetService;

    public StarWarsController(PlanetService planetService) {
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
    public ResponseEntity<List<PlanetModel>> listPlanets(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-planet-by-name")
    public ResponseEntity<PlanetModel> getPlanetByName(@RequestBody String name){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-planet-by-id")
    public ResponseEntity<PlanetModel> getPlanetById(@RequestBody Long id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-planet-by-name")
    public ResponseEntity<PlanetModel> deletePlanetByName(@RequestBody String name){
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete-planet-by-id")
    public ResponseEntity<PlanetModel> deletePlanetById(@RequestBody Long id){
        return ResponseEntity.ok().build();
    }


}
