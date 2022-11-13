package com.example.gamezone.service.impl;

import com.example.gamezone.persistence.PersistenceClient;
import com.example.gamezone.service.PersonService;
import com.example.gamezone.utilities.ChangerFXML;
import com.example.gamezone.utilities.LoginAction;
import com.example.gamezone.utilities.SercherObject;

public class Arcade {
    private final PersonService administratorService;
    private final AttractionServiceImpl attractionService;
    private final ClientServiceImpl clientService;
    private final EmployeeServiceImpl employeeService;
    private final LoanServiceImpl loanService;
    private final PersistenceClient persistenceClient;
    private final ChangerFXML changerFXML;
    private final SercherObject sercherObject;
    private final LoginAction loginAction;

    public Arcade() {
        this.administratorService = new AdministratorServiceImpl();
        this.attractionService = new AttractionServiceImpl();
        this.clientService = new ClientServiceImpl();
        this.employeeService = new EmployeeServiceImpl();
        this.loanService = new LoanServiceImpl();
        this.persistenceClient=new PersistenceClient();
        this.changerFXML=new ChangerFXML();
        this.sercherObject=new SercherObject();
        this.loginAction=new LoginAction();
    }

    public SercherObject getSercherObject() {return sercherObject;}
    public ChangerFXML getChangerFXML() {return changerFXML;}
    public PersistenceClient getPersistenceClient() {
        return persistenceClient;
    }
    public PersonService getAdministratorService() {
        return administratorService;
    }
    public AttractionServiceImpl getAttractionService() {
        return attractionService;
    }
    public ClientServiceImpl getClientService() {
        return clientService;
    }
    public EmployeeServiceImpl getEmployeeService() {
        return employeeService;
    }
    public LoanServiceImpl getLoanService() {
        return loanService;
    }

    public LoginAction getLoginAction() {
        return loginAction;
    }
}
