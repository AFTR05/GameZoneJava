package com.example.gamezone.service.impl;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.utilities.SortByName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class PracticeCollectionService {
    private ObservableList<ClientDTO> listClient= FXCollections.observableArrayList();

    public ObservableList<ClientDTO> getListClient() {
        return listClient;
    }

    public void setListClient(ObservableList<ClientDTO> listClient) {
        this.listClient = listClient;
    }

    public void limitJustOne(ArrayList<ClientDTO> listClient){
        listClient.stream().limit(1).forEach(System.out::println);
    }

    public void organizeByLetter(ArrayList<ClientDTO> listClient){
        Collections.sort(listClient,new SortByName());
    }
}
