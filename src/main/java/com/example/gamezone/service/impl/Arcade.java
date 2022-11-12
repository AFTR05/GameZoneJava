package com.example.gamezone.service.impl;

import com.example.gamezone.service.PersonService;

public class Arcade {
    private final PersonService administratorService;
    private final AttractionServiceImpl attractionService;
    private final PersonService clientService;
    private final PersonService employeeService;
    private final LoanServiceImpl loanService;
    private final PracticeCollectionService practiceCollectionService;

    public Arcade() {
        this.administratorService = new AdministratorServiceImpl();
        this.attractionService = new AttractionServiceImpl();
        this.clientService = new ClientServiceImpl();
        this.employeeService = new EmployeeServiceImpl();
        this.loanService = new LoanServiceImpl();
        this.practiceCollectionService = new PracticeCollectionService();
    }

    public PersonService getAdministratorService() {
        return administratorService;
    }

    public AttractionServiceImpl getAttractionService() {
        return attractionService;
    }

    public PersonService getClientService() {
        return clientService;
    }

    public PersonService getEmployeeService() {
        return employeeService;
    }

    public LoanServiceImpl getLoanService() {
        return loanService;
    }

    public PracticeCollectionService getPracticeCollectionService() {
        return practiceCollectionService;
    }
}
