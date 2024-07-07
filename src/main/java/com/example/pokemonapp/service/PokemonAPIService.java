package com.example.pokemonapp.service;

import com.example.pokemonapp.model.PokemonModel;
import com.example.pokemonapp.model.PokemonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonAPIService {
    private static PokemonAPIService instance;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon";

    private PokemonAPIService() {}

    public static synchronized PokemonAPIService getInstance() {
        if (instance == null) {
            instance = new PokemonAPIService();
        }
        return instance;
    }

    public List<PokemonModel> getPokemons(int offset, int limit) {
        String url = POKE_API_URL + "?offset=" + offset + "&limit=" + limit;
        ResponseEntity<PokemonResponse> response = restTemplate.getForEntity(url, PokemonResponse.class);
        return response.getBody().getResults();
    }

}
