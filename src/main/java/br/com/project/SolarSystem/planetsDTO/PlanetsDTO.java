package br.com.project.SolarSystem.planetsDTO;

import br.com.project.SolarSystem.model.Planets;

public class PlanetsDTO {

    private Long id;
    private String nomePlanetas;
    private double tamanho;

    public PlanetsDTO(Planets planets){
        this.id = planets.getId();
        this.nomePlanetas = planets.getNomePlanetas();
        this.tamanho = planets.getTamanho();
    }

    public PlanetsDTO(){
    }

    public Long getId() {
        return id;
    }

    public String getNomePlanetas() {
        return nomePlanetas;
    }

    public double getTamanho() {
        return tamanho;
    }

    public PlanetsDTO(Long id, String nomePlanetas, double tamanho) {
        this.id = id;
        this.nomePlanetas = nomePlanetas;
        this.tamanho = tamanho;
    }


}
