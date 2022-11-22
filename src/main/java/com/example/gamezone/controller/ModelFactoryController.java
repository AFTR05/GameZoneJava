package com.example.gamezone.controller;

import com.example.gamezone.service.ModelFactoryService;
import com.example.gamezone.service.impl.Arcade;

public class ModelFactoryController implements ModelFactoryService {



    private Arcade arcade;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public Arcade getArcade() {
        return arcade;
    }

    public void setArcade(Arcade arcade) {
        this.arcade = arcade;
    }

    public ModelFactoryController() {
        arcade = new Arcade();
    }

    @Override
    public void createClient(String name, String email, String password) {
        arcade.getClientService().createPerson(name, email, password);
    }
    @Override
    public void createEmployee(String name, String email, String password) {
        arcade.getEmployeeService().createPerson(name, email, password);
    }
    @Override
    public void createAdmin(String name, String email, String password) {
        arcade.getAdministratorService().createPerson(name, email, password);
    }

    @Override
    public void deleteEmployee(String name, String password,ModelFactoryController mfc) {
        arcade.getEmployeeService().deletePerson(name,password,mfc);
    }
}
