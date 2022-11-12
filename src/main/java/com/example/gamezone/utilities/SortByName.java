package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.ClientDTO;

import java.util.Comparator;

public class SortByName implements Comparator<ClientDTO> {
    public int compare(ClientDTO a, ClientDTO b)
    {
        return a.getName().compareTo(b.getName());
    }


}
