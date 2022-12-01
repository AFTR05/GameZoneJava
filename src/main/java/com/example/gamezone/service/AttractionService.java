package com.example.gamezone.service;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.TypeAttraction;

public interface AttractionService {
    void createAttraction(String name, String code, Double price, TypeAttraction type);
    void deleteAttraction(String name, String code, Double price, TypeAttraction type);
    void updateAttraction(String name, String code, Double price, TypeAttraction type, AttractionDTO attractionSelected);

}
