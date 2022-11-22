package com.example.gamezone.service;

import com.example.gamezone.controller.ModelFactoryController;

public interface ModelFactoryService {
    void createClient(String name,String email,String password);
    void createEmployee(String name,String email,String password);
    void createAdmin(String name,String email,String password);
    void deleteEmployee(String name, String password, ModelFactoryController mfc);
}
