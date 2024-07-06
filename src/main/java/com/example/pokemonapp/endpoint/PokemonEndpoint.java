package com.example.pokemonapp.endpoint;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.service.PokemonSOAPService;
import com.example.pokemonapp.ws.schema.GetPokemonsRequest;
import com.example.pokemonapp.ws.schema.GetPokemonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/pokemonapp";

    private final PokemonSOAPService pokemonService;

    @Autowired
    public PokemonEndpoint(PokemonSOAPService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonsRequest")
    @ResponsePayload
    public GetPokemonsResponse getPokemons(@RequestPayload GetPokemonsRequest request) {
        List<Pokemon> pokemons = pokemonService.getPokemons(request.getOffset(), request.getLimit());

        // Construir GetPokemonsResponse
        GetPokemonsResponse response = new GetPokemonsResponse();
        response.getPokemons().addAll(pokemons); // Agregar la lista de pokemons al response

        return response;
    }

}
