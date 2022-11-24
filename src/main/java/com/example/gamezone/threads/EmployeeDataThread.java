package com.example.gamezone.threads;

public class EmployeeDataThread implements Runnable{
    @Override
    public void run() {
        System.out.println("El empleado a sido subido");
    }
}
