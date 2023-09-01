package br.com.project.SolarSystem;

import br.com.project.SolarSystem.model.Planets;
import br.com.project.SolarSystem.service.PlanetsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SolarSystemApplicationTests {

	private PlanetsService defaoutPlanetsService;

	private PlanetsService getPlanetsService(PlanetsService planetsService){
		return  this.defaoutPlanetsService = planetsService;
	}

	@Test
	void contextLoads() {
	}

}
