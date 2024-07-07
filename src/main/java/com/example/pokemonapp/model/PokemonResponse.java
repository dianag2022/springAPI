package com.example.pokemonapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {
    private List<PokemonModel> results;

    // Getters and setters
    public List<PokemonModel> getResults() {
        return results;
    }

    public void setResults(List<PokemonModel> results) {
        this.results = results;
    }
}
