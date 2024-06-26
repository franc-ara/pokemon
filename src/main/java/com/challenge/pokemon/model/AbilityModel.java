package com.challenge.pokemon.model;

import lombok.Data;

@Data
public class AbilityModel {
    private AbilityDataModel ability;
    private Boolean is_hidden;
    private Integer slot;
}
