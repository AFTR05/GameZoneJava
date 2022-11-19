package com.example.gamezone.utilities;

import com.example.gamezone.model.Person;
import javafx.scene.control.TextField;

public class UpdaterObject {
    public void personUpdate(Person person, String name, String email,String password){
        person.setName(name);
        person.setEmail(email);
        person.setPassword(password);
    }
}
