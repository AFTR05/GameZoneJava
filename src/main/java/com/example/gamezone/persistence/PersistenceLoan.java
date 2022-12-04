package com.example.gamezone.persistence;

import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Loan;
import com.example.gamezone.service.impl.Arcade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceLoan {
    private Arcade arcade;

    public PersistenceLoan(Arcade arcade) {
        this.arcade = arcade;
    }

    public static final String RUTE_ARCHIVE_LOAN = "src/main/java/com/example/gamezone/Data/loans.txt";

    public void saveEmployee(ArrayList<Loan> listLoans) throws IOException {
        String contenido = "";
        for(Loan loan:listLoans) {
            contenido+= loan.getBeginDate()+"/"+loan.getEndDate()+"/"+loan.getClient().getName()+"/"+loan.getClient().getPassword()+"/"+loan.getAttraction().getCode()+"\n";
        }
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_LOAN, contenido, false);
    }

    public ArrayList<Loan> chargeLoan() throws FileNotFoundException, IOException {
        ArrayList<Loan> loans = new ArrayList<Loan>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_LOAN);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            line= content.get(i);
            Loan myLoan=new Loan();
            myLoan.setBeginDate(LocalDateTime.parse(line.split("/")[0]));
            myLoan.setEndDate(LocalDateTime.parse(line.split("/")[1]));
            myLoan.setClient(arcade.getSercherObject().getClient(line.split("/")[2],line.split("/")[3],arcade.getClientService().getListClients()));
            myLoan.setAttraction(arcade.getSercherObject().getAttraction(line.split("/")[4],arcade.getAttractionService().getAttractions()));
            loans.add(myLoan);
        }
        return loans;
    }
}
