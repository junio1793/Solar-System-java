package br.com.project.SolarSystem.repository;

import br.com.project.SolarSystem.model.Planets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface PlanetsRepository extends JpaRepository<Planets,Long> {


}
