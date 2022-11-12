package com.example.gamezone.service.impl;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.model.Client;
import com.example.gamezone.utilities.SortByName;

import java.util.*;

public class PracticeCollectionService {
    Set<ClientDTO> listClient=new HashSet<ClientDTO>();

    public void limitJustOne(ArrayList<ClientDTO> listClient){
        listClient.stream().limit(1).forEach(System.out::println);
    }

    public void organizeByLetter(ArrayList<ClientDTO> listClient){
        Collections.sort(listClient,new SortByName());
    }
}
