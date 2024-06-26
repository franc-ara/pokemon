package com.challenge.pokemon.mapper;

import com.challenge.pokemon.model.ItemModel;
import com.challenge.pokemon.pokedex.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemModel toModel(Item item);

    Item toEntity(ItemModel itemModel);
}
