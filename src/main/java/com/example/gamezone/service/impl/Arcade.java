package com.example.gamezone.service.impl;

import com.example.gamezone.controller.AdminModalEmployeeSalaryViewController;
import com.example.gamezone.controller.AdminProfileViewController;
import com.example.gamezone.controller.ClientProfileViewController;
import com.example.gamezone.controller.EmployeeProfileViewController;
import com.example.gamezone.persistence.PersistenceAdmin;
import com.example.gamezone.persistence.PersistenceAttraction;
import com.example.gamezone.persistence.PersistenceClient;
import com.example.gamezone.persistence.PersistenceEmployee;
import com.example.gamezone.utilities.*;
import com.example.gamezone.validations.*;

public class Arcade {
    private final PersistenceAttraction persistenceAttraction;
    private final PreparatorTable preparatorTable;
    private final ShowInputs showInputs;
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
    private final VerificatorClone verificatorClone;
    private final ChargerData chargerData;
    private final AlertGenerator alertGenerator;
    private final CloneValidator cloneValidator;
    private final EmptyValidator emptyValidator;
    private final UpdaterObject updaterObject;
    private final EmailValidator emailValidator;
    private final ConvertToObservableList convertToObservableList;
    private final DeleteInfoInputs deleteInfoInputs;
    private final SelectValidator selectValidator;
    private final AdjustableData adjustableData;
    private final AdminModalEmployeeSalaryViewController adminModalEmployeeSalaryViewController;
    private final SalaryValidation salaryValidation;
    private final ComboBoxAdder comboBoxAdder;
    private final PriceValidator priceValidator;
    private final TypeConverter typeConverter;
    public Arcade() {
        this.priceValidator=new PriceValidator(this);
        this.typeConverter=new TypeConverter();
        this.comboBoxAdder=new ComboBoxAdder();
        this.persistenceAttraction=new PersistenceAttraction(this);
        this.salaryValidation=new SalaryValidation(this);
        this.adminModalEmployeeSalaryViewController=new AdminModalEmployeeSalaryViewController();
        this.adjustableData =new AdjustableData(this);
        this.selectValidator=new SelectValidator(this);
        this.deleteInfoInputs=new DeleteInfoInputs();
        this.preparatorTable=new PreparatorTable();
        this.convertToObservableList=new ConvertToObservableList();
        this.emailValidator=new EmailValidator(this);
        this.updaterObject=new UpdaterObject();
        this.cloneValidator=new CloneValidator(this);
        this.emptyValidator=new EmptyValidator(this);
        this.alertGenerator=new AlertGenerator();
        this.showInputs=new ShowInputs();
        this.chargerData=new ChargerData(this);
        this.verificatorClone=new VerificatorClone();
        this.adminViewController=new AdminProfileViewController();
        this.clientViewController=new ClientProfileViewController();
        this.employeeViewController=new EmployeeProfileViewController();
        this.persistenceAdmin=new PersistenceAdmin();
        this.persistenceEmployee=new PersistenceEmployee();
        this.administratorService = new AdministratorServiceImpl(this);
        this.attractionService = new AttractionServiceImpl(this);
        this.clientService = new ClientServiceImpl(this);
        this.employeeService = new EmployeeServiceImpl(this);
        this.loanService = new LoanServiceImpl();
        this.persistenceClient=new PersistenceClient();
        this.changerFXML=new ChangerFXML();
        this.sercherObject=new SercherObject();
        this.loginAction=new LoginAction(this);
    }

    public PriceValidator getPriceValidator() {
        return priceValidator;
    }

    public TypeConverter getTypeConverter() {
        return typeConverter;
    }

    public ComboBoxAdder getComboBoxAdder() {
        return comboBoxAdder;
    }


    public PersistenceAttraction getPersistenceAttraction() {
        return persistenceAttraction;
    }

    public SalaryValidation getSalaryValidation() {
        return salaryValidation;
    }

    public AdminModalEmployeeSalaryViewController getAdminModalEmployeeSalaryViewController() {
        return adminModalEmployeeSalaryViewController;
    }

    public AdjustableData getAjustableData() {
        return adjustableData;
    }

    public SelectValidator getSelectValidator() {
        return selectValidator;
    }

    public DeleteInfoInputs getDeleteInfoInputs() {
        return deleteInfoInputs;
    }

    public PreparatorTable getPreparatorTable() {
        return preparatorTable;
    }

    public ConvertToObservableList getConvertToObservableList() {
        return convertToObservableList;
    }

    public EmailValidator getEmailValidator() {
        return emailValidator;
    }

    public UpdaterObject getUpdaterObject() {
        return updaterObject;
    }

    public CloneValidator getCloneValidator() {
        return cloneValidator;
    }

    public EmptyValidator getEmptyValidator() {
        return emptyValidator;
    }

    public AlertGenerator getAlertGenerator() {
        return alertGenerator;
    }

    public ShowInputs getShowInputs() {
        return showInputs;
    }

    public ChargerData getChargerData() {
        return chargerData;
    }

    public VerificatorClone getVerificatorClone() {
        return verificatorClone;
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
