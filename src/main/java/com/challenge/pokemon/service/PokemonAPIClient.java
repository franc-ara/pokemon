package com.challenge.pokemon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonAPIClient", url = "https://pokeapi.co/api/v2")
public interface PokemonAPIClient {

    @GetMapping("/pokemon/{name}")
    String getPokemonByName(@PathVariable("name") String name);

}
