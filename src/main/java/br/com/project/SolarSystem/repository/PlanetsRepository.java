package br.com.project.SolarSystem.repository;

import br.com.project.SolarSystem.model.Planets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetsRepository extends JpaRepository<Planets,Long> {
}
