package com.example.gamezone.controller;

import com.example.gamezone.service.impl.Arcade;

public class ModelFactoryController {
    private Arcade arcade;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        arcade = new Arcade();
    }
}
