package com.example.gamezone.threads;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Client;

public class AdminDataThread implements Runnable{
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    @Override
    public void run() {
        System.out.println("El admin a sido subido");

    }
}
