package br.com.project.SolarSystem.controller;

import br.com.project.SolarSystem.model.Planets;
import br.com.project.SolarSystem.service.PlanetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping( "/listarPlanetas")
public class PlanetEndpoint {

    @Autowired
    private PlanetsService planetsService;

    @GetMapping
    public ResponseEntity<List<Planets>> getAll(){
        List<Planets> result = planetsService.listarTudo();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Planets> findById(@PathVariable long id){
        return ResponseEntity.ok(planetsService.findById(id));
    }

    @GetMapping(value = "/planetaMod2")
    public ResponseEntity<List<Planets>> getTamanhoPar(){
        return ResponseEntity.ok(planetsService.findtModPlanet());
    }

    @GetMapping(value = "/maiorPlaneta")
    public ResponseEntity<Planets> getMaiorPlaneta(){
        return ResponseEntity.ok(planetsService.findtBigesPlanet());
    }
}
