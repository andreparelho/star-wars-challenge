package com.andreparelho.app.starwarschallenge.controller;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
import com.andreparelho.app.starwarschallenge.service.StarWarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @PostMapping("/create-planet")
    public ResponseEntity<PlanetModel> createPlanet(@RequestBody String name, @RequestBody String climate, @RequestBody String ground){
        return ResponseEntity.ok().build();
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