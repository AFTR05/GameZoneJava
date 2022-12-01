package com.example.gamezone.persistence;

import com.example.gamezone.model.Administrator;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.service.impl.Arcade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceAttraction {
    private final Arcade arcade;

    public PersistenceAttraction(Arcade arcade) {
        this.arcade = arcade;
    }

    public static final String RUTE_ARCHIVE_ATTRACTION = "src/main/java/com/example/gamezone/Data/attractions.txt";

    public void saveAttractions(HashSet<Attraction> listClient) throws IOException {
        String contenido = "";
        for(Attraction attraction: listClient) {
            contenido+= attraction.getName()+"/"+attraction.getCode()+"/"+attraction.getPrice()+"/"+attraction.getTypeAttraction().getCategory()+"\n";
        }
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_ATTRACTION, contenido, false);
    }

    public HashSet<Attraction> chargeAttractions() throws FileNotFoundException, IOException {
        HashSet<Attraction> attractions = new HashSet<Attraction>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_ATTRACTION);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            Attraction myAttraction = new Attraction();
            line= content.get(i);
            myAttraction.setName(line.split("/")[0]);
            myAttraction.setCode(line.split("/")[1]);
            myAttraction.setPrice(Double.parseDouble(line.split("/")[2]));
            myAttraction.setTypeAttraction(arcade.getTypeConverter().stringToType(line.split("/")[3]));
            attractions.add(myAttraction);
        }
        return attractions;
    }


}
