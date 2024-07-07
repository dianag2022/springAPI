package com.example.pokemonapp.service;

import com.example.pokemonapp.model.PokemonModel;
import org.springframework.stereotype.Service;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

import java.util.List;

@WebService(serviceName = "PokemonSOAPService")
@Service
public class PokemonSOAPService {
    private final PokemonAPIService pokemonAPIService = PokemonAPIService.getInstance();

    @WebMethod
    public List<PokemonModel> getPokemons(int offset, int limit) {
        return pokemonAPIService.getPokemons(offset, limit);
    }
}
