package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.service.impl.Arcade;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChargerData {
    private final Arcade arcade;
    public ChargerData(Arcade arcade){
        this.arcade=arcade;
    }
    public void chargeData(){
            ExecutorService service= Executors.newFixedThreadPool(5);
            chargeAdministrator(service);
            chargeEmployees(service);
            chargeClients(service);
            chargeAttractions(service);
            chargeLoans(service);
            service.shutdown();
    }

    public void chargeAdministrator(ExecutorService service){
        service.submit(()-> {
            try {
                arcade.getAdministratorService().setAdministrator(arcade.getPersistenceAdmin().chargeAdmin());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void chargeClients(ExecutorService service){
        service.submit(()-> {
            try {
                arcade.getClientService().setListClients(arcade.getPersistenceClient().chargeClient());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void chargeEmployees(ExecutorService service){
        service.submit(()-> {
            try {
                arcade.getEmployeeService().setListEmployee(arcade.getPersistenceEmployee().chargeEmployee());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void chargeAttractions(ExecutorService service){
        service.submit(()-> {
            try {
                arcade.getAttractionService().setAttractions(arcade.getPersistenceAttraction().chargeAttractions());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void chargeLoans(ExecutorService service){
        service.submit(()-> {
            try {
                arcade.getLoanService().setListLoans(arcade.getPersistenceLoan().chargeLoan());
                arcade.getLoanService().setListLoans(arcade.getTimeComparator().editForTime(arcade.getLoanService().getListLoans()));
                arcade.getPersistenceLoan().saveEmployee(arcade.getLoanService().getListLoans());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
