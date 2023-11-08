package com.andreparelho.app.starwarschallenge.controller;

import com.andreparelho.app.starwarschallenge.model.PlanetModel;
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
    public ResponseEntity<PlanetModel> createPlanet(@RequestBody String name, @RequestBody String climate, @RequestBody String ground){
        PlanetModel planet = this.planetService.createPlanet(name, climate, ground);
        if (planet != null){
            return ResponseEntity.ok(planet);
        }
        return ResponseEntity.status(400).build();
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
