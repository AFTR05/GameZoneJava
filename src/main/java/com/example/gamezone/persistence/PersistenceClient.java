package com.example.gamezone.persistence;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PersistenceClient {
    public static final String RUTE_ARCHIVE_CLIENT = "src/main/java/com/example/gamezone/Data/clients.txt";

    public void saveClients(HashSet<Client> listClient) throws IOException {
        String contenido = "";
        for(Client client: listClient) {
            contenido+= client.getName()+"/"+client.getEmail()+"/"+client.getPassword()+"/"+client.getAmountLoan()+"\n";
        }
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_CLIENT, contenido, false);
    }

    public HashSet<Client> chargeClient() throws FileNotFoundException, IOException {
        HashSet<Client> clients = new HashSet<Client>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_CLIENT);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            Client myClient = new Client();
            line= content.get(i);
            myClient.setName(line.split("/")[0]);
            myClient.setEmail(line.split("/")[1]);
            myClient.setPassword(line.split("/")[2]);
            myClient.setAmountLoan(Integer.parseInt(line.split("/")[3]));
            clients.add(myClient);
        }
        return clients;
    }

    public ObservableList<ClientDTO> chargeClientDTO() throws FileNotFoundException, IOException {
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
