
package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.VersionDetailModel;
import com.challenge.pokemon.pokedex.VersionDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VersionMapper.class})
public interface VersionDetailMapper {
    VersionDetailMapper INSTANCE = Mappers.getMapper(VersionDetailMapper.class);

    VersionDetailModel toModel(VersionDetail versionDetail);

    VersionDetail toEntity(VersionDetailModel versionDetailModel);
}
