package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.HeldItemModel;
import com.challenge.pokemon.pokedex.HeldItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ItemMapper.class, VersionDetailMapper.class})
public interface HeldItemMapper {
    HeldItemMapper INSTANCE = Mappers.getMapper(HeldItemMapper.class);

    @Mapping(source = "version_details", target = "versionDetails")
    HeldItem toEntity(HeldItemModel model);

    @Mapping(source = "versionDetails", target = "version_details")
    HeldItemModel toModel(HeldItem entity);
}
