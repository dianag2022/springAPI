package com.example.pokemonapp.endpoint;

import com.example.pokemonapp.model.PokemonModel;
import com.example.pokemonapp.service.PokemonSOAPService;
import com.example.pokemonapp.ws.schema.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.pokemonapp.ws.schema.GetPokemonsRequest;
import com.example.pokemonapp.ws.schema.GetPokemonsResponse;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/pokemonapp/getAll";

    @Autowired
    private PokemonSOAPService pokemonService;

    public PokemonEndpoint(PokemonSOAPService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonsRequest")
    @ResponsePayload
    public GetPokemonsResponse getPokemons(@RequestPayload GetPokemonsRequest request) {
        //Get pokemons from PokemonSOAPService and this one call the API Request
        List<PokemonModel> pokemons = pokemonService.getPokemons(request.getOffset(), request.getLimit());
        //Map to return type Schema
        List<Pokemon> schemaPokemons = pokemons.stream()
                .map(this::convertToSchemaPokemon)
                .collect(Collectors.toList());

        GetPokemonsResponse response = new GetPokemonsResponse();
        response.getPokemons().addAll(schemaPokemons);

        return response;
    }

    private Pokemon convertToSchemaPokemon(PokemonModel modelPokemon) {
        Pokemon schemaPokemon = new Pokemon();
        schemaPokemon.setUrl(modelPokemon.getUrl());
        schemaPokemon.setName(modelPokemon.getName());

        return schemaPokemon;
    }

}
