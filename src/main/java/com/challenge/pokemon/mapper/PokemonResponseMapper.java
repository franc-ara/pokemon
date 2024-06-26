package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.PokemonResponseModel;
import com.challenge.pokemon.pokedex.PokemonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {AbilityMapper.class, HeldItemMapper.class})
public interface PokemonResponseMapper {
    PokemonResponseMapper INSTANCE = Mappers.getMapper(PokemonResponseMapper.class);

    @Mapping(source = "baseExperience", target = "base_experience")
    @Mapping(source = "heldItems", target = "held_items")
    @Mapping(source = "locationAreaEncounters", target = "location_area_encounters")
    PokemonResponseModel toModel(PokemonResponse entity);

    @Mapping(source = "base_experience", target = "baseExperience")
    @Mapping(source = "held_items", target = "heldItems")
    @Mapping(source = "location_area_encounters", target = "locationAreaEncounters")
    PokemonResponse toEntity(PokemonResponseModel model);
}
