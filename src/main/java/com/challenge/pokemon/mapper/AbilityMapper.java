package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.AbilityModel;
import com.challenge.pokemon.pokedex.Ability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AbilityDataMapper.class})
public interface AbilityMapper {
    AbilityMapper INSTANCE = Mappers.getMapper(AbilityMapper.class);

    @Mapping(source = "is_hidden", target = "isHidden")
    Ability toEntity(AbilityModel model);

    @Mapping(source = "isHidden", target = "is_hidden")
    AbilityModel toModel(Ability entity);
}
