package com.challenge.pokemon.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonResponseModel {
    private Integer id;
    private String name;
    private List<AbilityModel> abilities;
    private Integer base_experience;
    private List<HeldItemModel> held_items;
    private String location_area_encounters;
}
