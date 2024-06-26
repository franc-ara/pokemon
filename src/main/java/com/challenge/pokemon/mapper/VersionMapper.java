
package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.VersionModel;
import com.challenge.pokemon.pokedex.Version;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VersionMapper {
    VersionMapper INSTANCE = Mappers.getMapper(VersionMapper.class);

    VersionModel toModel(Version version);

    Version toEntity(VersionModel versionModel);
}
