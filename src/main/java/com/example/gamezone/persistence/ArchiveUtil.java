package com.example.gamezone.persistence;

import java.io.*;
import java.util.ArrayList;

public class ArchiveUtil {
    public static ArrayList<String> readArchive(String ruta) throws IOException {
        ArrayList<String> content = new ArrayList<String>();
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine())!= null) {
            content.add(line);
        }
        br.close();
        fr.close();
        return content;
    }

    public static void saveArchive(String rute, String content, boolean b) throws IOException {
        FileWriter fw = new FileWriter(rute, b);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(content);
        bfw.close();
        fw.close();

    }
}
