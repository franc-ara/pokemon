package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.AbilityDataModel;
import com.challenge.pokemon.pokedex.AbilityData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AbilityDataMapper {
    AbilityDataMapper INSTANCE = Mappers.getMapper(AbilityDataMapper.class);

    AbilityDataModel toModel(AbilityData abilityData);

    AbilityData toEntity(AbilityDataModel abilityDataModel);
}
