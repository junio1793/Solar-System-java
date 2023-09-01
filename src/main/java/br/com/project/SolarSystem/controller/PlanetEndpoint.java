package br.com.project.SolarSystem.controller;

import br.com.project.SolarSystem.model.Planets;
import br.com.project.SolarSystem.service.PlanetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/Planetas")
public class PlanetEndpoint {

    private  PlanetsService defaultPanetsService;

    private PlanetsService getPlanetsService(PlanetsService planetsService){
        return this.defaultPanetsService = planetsService;
    }

    @GetMapping(value = "/maior planeta")
    public ResponseEntity<Planets> getMaiorPlaneta(){
        return ResponseEntity.ok(defaultPanetsService.getMaiorPlaneta());
    }

    @GetMapping(value = "/menor planeta")
    public ResponseEntity<Planets> getMenorPlaneta(){
       return ResponseEntity.ok(defaultPanetsService.getMenorPlaneta());
    }

    @GetMapping(value = "/meior que a terra")
    public ResponseEntity<List<Planets>> getMaiorQueTerra(){
        return ResponseEntity.ok(defaultPanetsService.maiorQueTerra());
    }

    @GetMapping(value = "/quantidade")
    public Long qtdPlanetas(){
        return defaultPanetsService.quantosPlanetas();
    }
}
