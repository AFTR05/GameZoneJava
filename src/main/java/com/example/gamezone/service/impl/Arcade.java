package com.example.gamezone.service.impl;

import com.example.gamezone.controller.AdminProfileViewController;
import com.example.gamezone.controller.ClientProfileViewController;
import com.example.gamezone.controller.EmployeeProfileViewController;
import com.example.gamezone.persistence.PersistenceAdmin;
import com.example.gamezone.persistence.PersistenceClient;
import com.example.gamezone.persistence.PersistenceEmployee;
import com.example.gamezone.utilities.ChangerFXML;
import com.example.gamezone.utilities.LoginAction;
import com.example.gamezone.utilities.SercherObject;

public class Arcade {
    private final PersistenceAdmin persistenceAdmin;
    private final AdministratorServiceImpl administratorService;
    private final AttractionServiceImpl attractionService;
    private final ClientServiceImpl clientService;
    private final EmployeeServiceImpl employeeService;
    private final LoanServiceImpl loanService;
    private final PersistenceClient persistenceClient;
    private final ChangerFXML changerFXML;
    private final SercherObject sercherObject;
    private final LoginAction loginAction;
    private final PersistenceEmployee persistenceEmployee;
    private final AdminProfileViewController adminViewController;
    private final ClientProfileViewController clientViewController;
    private final EmployeeProfileViewController employeeViewController;

    public Arcade() {
        this.adminViewController=new AdminProfileViewController();
        this.clientViewController=new ClientProfileViewController();
        this.employeeViewController=new EmployeeProfileViewController();
        this.persistenceAdmin=new PersistenceAdmin();
        this.persistenceEmployee=new PersistenceEmployee();
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

    public PersistenceAdmin getPersistenceAdmin() {
        return persistenceAdmin;
    }

    public AdminProfileViewController getAdminViewController() {
        return adminViewController;
    }

    public ClientProfileViewController getClientViewController() {
        return clientViewController;
    }

    public EmployeeProfileViewController getEmployeeViewController() {
        return employeeViewController;
    }

    public SercherObject getSercherObject() {return sercherObject;}
    public ChangerFXML getChangerFXML() {return changerFXML;}
    public PersistenceClient getPersistenceClient() {
        return persistenceClient;
    }
    public AdministratorServiceImpl getAdministratorService() {
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

    public PersistenceEmployee getPersistenceEmployee() {
        return persistenceEmployee;
    }

    public LoginAction getLoginAction() {
        return loginAction;
    }
}
