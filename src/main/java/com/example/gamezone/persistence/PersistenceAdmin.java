package com.example.gamezone.persistence;

import com.example.gamezone.model.Administrator;
import com.example.gamezone.model.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceAdmin {
    public static final String RUTE_ARCHIVE_ADMIN = "src/main/java/com/example/gamezone/Data/admin.txt";

    public void saveAdministrator(Administrator administrator) throws IOException {
        String contenido= administrator.getName()+"/"+administrator.getEmail()+"/"+administrator.getPassword()+"\n";
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_ADMIN, contenido, false);
    }

    public Administrator chargeAdmin() throws FileNotFoundException, IOException {
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_ADMIN);
        String line = "";
        Administrator admin=new Administrator();
        for (int i = 0;i<content.size(); i++) {
            line= content.get(i);
            admin.setName(line.split("/")[0]);
            admin.setEmail(line.split("/")[1]);
            admin.setPassword(line.split("/")[2]);
        }
        return admin;
    }
}
