package br.com.project.SolarSystem.service;

import br.com.project.SolarSystem.model.Planets;
import br.com.project.SolarSystem.planetsDTO.PlanetsDTO;
import br.com.project.SolarSystem.repository.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetsService {

    @Autowired
    private PlanetsRepository planetsRepository;

    @Autowired
    private PlanetsDTO planetsDTO;

    public PlanetsService(PlanetsRepository planetsRepository,PlanetsDTO planetsDTO) {
        this.planetsRepository = planetsRepository;
        this.planetsDTO = planetsDTO;
    }

    private List<Planets> planetas =  planetsRepository.findAll();

        public List<Planets> listarTudo(){
        return planetas.stream()
                .filter(planets -> planets.getTamanho() % 2 == 0)
                .collect(Collectors.toList());
        }

        public Planets getMaiorPlaneta(){
            return planetas.stream()
                    .max(Comparator.comparingDouble(Planets::getTamanho))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "lgo de errado aconteceu"));
        }

        public Planets getMenorTamanho(){
            return planetas.stream()
                    .min(Comparator.comparingDouble(planetsDTO.getTamanho()))
                    .orElseThrow(null);
        }

}
