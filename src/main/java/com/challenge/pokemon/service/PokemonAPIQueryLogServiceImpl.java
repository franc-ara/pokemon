package com.challenge.pokemon.service;

import com.challenge.pokemon.entity.PokemonAPIQueryLog;
import com.challenge.pokemon.repository.PokemonAPIQueryLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class PokemonAPIQueryLogServiceImpl implements PokemonAPIQueryLogService{

    private PokemonAPIQueryLogRepository pokemonAPIQueryLogRepository;

    public PokemonAPIQueryLogServiceImpl(PokemonAPIQueryLogRepository pokemonAPIQueryLogRepository){
        this.pokemonAPIQueryLogRepository = pokemonAPIQueryLogRepository;
    }

    @Override
    public void registryQuery(PokemonAPIQueryLog pokemonAPIQueryLog) {
        pokemonAPIQueryLogRepository.save(pokemonAPIQueryLog);
    }
}
