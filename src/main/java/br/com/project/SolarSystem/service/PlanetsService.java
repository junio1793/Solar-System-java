package br.com.project.SolarSystem.service;

import br.com.project.SolarSystem.model.Planets;
import br.com.project.SolarSystem.repository.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//algumas services como achar o maior e menor planeta e encontrar pelo nome ou ID

@Service
public class PlanetsService {

    private final PlanetsRepository planetsRepository;

    public PlanetsService(PlanetsRepository planetsRepository){
        this.planetsRepository = planetsRepository;
    }

        @Transactional
        public List<Planets> tamanhoPar(){
            List<Planets> planetas =  planetsRepository.findAll();
            return planetas.stream()
                .filter(planets -> planets.getTamanho() % 2 == 0)
                        .collect(Collectors.toList());
        }

        @Transactional
        public Planets getMaiorPlaneta(){
            List<Planets> planetas =  planetsRepository.findAll();
            return planetas.stream()
                    .max(Comparator.comparingDouble(Planets::getTamanho))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "algo de errado aconteceu"));
        }

        @Transactional
        public Planets getMenorPlaneta(){
            List<Planets> planetas =  planetsRepository.findAll();
            return planetas.stream()
                    .min(Comparator.comparingDouble(Planets::getTamanho))
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "algo de errado aconteceu"));
        }

        @Transactional
        public List<Planets> maiorQueTerra(){
            List<Planets> planetas = planetsRepository.findAll();
            return planetas.stream()
                    .sorted(Comparator.comparing(Planets::getNomePlanetas))
                    .filter(planets -> planets.getTamanho() <  12756.2)
                    .collect(Collectors.toList());
        }

        public Long quantosPlanetas(){
            List<Planets> planetas =  planetsRepository.findAll();
            if(planetas.isEmpty()){
                return null;
            }else{
                Long count = planetas.stream().filter(planets -> planets.getId() > 0).count();
                return count;
            }

        }

}
