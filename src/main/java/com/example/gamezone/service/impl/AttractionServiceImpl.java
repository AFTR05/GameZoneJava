package com.example.gamezone.service.impl;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.TypeAttraction;
import com.example.gamezone.service.AttractionService;

import java.util.HashSet;

public class AttractionServiceImpl implements AttractionService {
    private HashSet<Attraction> attractions;
    private Arcade arcade;
    public AttractionServiceImpl(Arcade arcade){
        this.arcade=arcade;
    }

    public Arcade getArcade() {
        return arcade;
    }

    @Override
    public void createAttraction(String name, String code, Double price, TypeAttraction type) {
        attractions.add(new Attraction(name,code,price,type));

    }
    @Override
    public void deleteAttraction(String name, String code, Double price, TypeAttraction type) {
        Attraction attraction=arcade.getSercherObject().getAttraction(code,attractions);
        if (attraction!=null){
            attractions.remove(attraction);
        }
    }

    @Override
    public void updateAttraction(String name, String code, Double price, TypeAttraction type, AttractionDTO attractionDTO) {
        Attraction attraction=arcade.getSercherObject().getAttraction(attractionDTO.getCode(),attractions);
        if (attraction!=null){
            attraction.setName(name);
            attraction.setPrice(price);
            attraction.setCode(code);
            attraction.setTypeAttraction(type);
        }
    }

    public HashSet<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(HashSet<Attraction> attractions) {
        this.attractions = attractions;
    }
}
