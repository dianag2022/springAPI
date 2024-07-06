package com.example.pokemonapp.service;

import com.example.pokemonapp.model.Pokemon;
import org.springframework.stereotype.Service;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

import java.util.List;

@WebService(serviceName = "PokemonSOAPService")
@Service
public class PokemonSOAPService {
    private final PokemonAPIService pokemonAPIService = PokemonAPIService.getInstance();

    @WebMethod
    public List<Pokemon> getPokemons(int offset, int limit) {
        return pokemonAPIService.getPokemons(offset, limit);
    }
}
