package com.challenge.pokemon.model;

import lombok.Data;

import java.util.List;

@Data
public class HeldItemModel {

    private ItemModel item;
    private List<VersionDetailModel> version_details;

}
