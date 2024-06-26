package com.challenge.pokemon.repository;

import com.challenge.pokemon.entity.PokemonAPIQueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonAPIQueryLogRepository extends JpaRepository<PokemonAPIQueryLog, Long> {
}
