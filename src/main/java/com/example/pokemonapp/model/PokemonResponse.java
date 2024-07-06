package com.example.pokemonapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {
    private List<Pokemon> results;

    // Getters y setters
    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
