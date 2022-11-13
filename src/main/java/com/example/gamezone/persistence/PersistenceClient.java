package com.example.gamezone.persistence;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenceClient {
    public static final String RUTE_ARCHIVE_CLIENT = "src/main/java/com/example/gamezone/Data/clients.txt";

    public static void savePeople(ArrayList<Client> listClient) throws IOException {
        String contenido = "";
        for(Client client: listClient) {
            contenido+= client.getName()+"/"+client.getCode()+"/"+client.getAmountLoan()+"\n";
        }
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_CLIENT, contenido, false);
    }

    public static ArrayList<Client> chargeClient() throws FileNotFoundException, IOException {
        ArrayList<Client> clients = new ArrayList<Client>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_CLIENT);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            Client myClient = new Client();
            line= content.get(i);
            myClient.setName(line.split("/")[0]);
            myClient.setCode(line.split("/")[1]);
            myClient.setAmountLoan(Integer.parseInt(line.split("/")[2]));
            clients.add(myClient);
        }
        return clients;
    }

    public static ObservableList<ClientDTO> chargeClientDTO() throws FileNotFoundException, IOException {
        ObservableList<ClientDTO> clients = FXCollections.observableArrayList();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_CLIENT);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            ClientDTO myClient = new ClientDTO();
            line= content.get(i);
            myClient.setName(line.split("/")[0]);
            myClient.setAmountLoan(Integer.parseInt(line.split("/")[2]));
            clients.add(myClient);
        }
        return clients;
    }

}
