package controller;

import model.dao.CompaniesDAO;
import model.dao.CompaniesDAOImpl;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class CompanyController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        CompaniesDAO companiesDAO = new CompaniesDAOImpl();
        int controlValue;
        int id;
        String name;

        ConsoleDataInput.writeMessage("----------------------COMPANY CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL PROJECTS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleDataInput.readInt();

        if (controlValue == 1) {
            ConsoleDataInput.writeMessage("INPUT NAME OF COMPANY TO CREATE");
            name = ConsoleDataInput.readString();
            companiesDAO.create(name);
        } else if (controlValue == 2) {
            ConsoleDataInput.writeMessage("INPUT ID TO DELETE COMPANY");
            id = ConsoleDataInput.readInt();
            companiesDAO.delete(id);
        } else if (controlValue == 3) {
            ConsoleDataInput.writeMessage("INPUT NAME OF COMPANY TO UPDATE");
            name = ConsoleDataInput.readString();
            companiesDAO.update(name);
        } else if (controlValue == 4) {
            companiesDAO.getAll();
        } else if (controlValue == 5) {
            ConsoleDataInput.writeMessage("INPUT NAME OF COMPANY TO FIND");
            name = ConsoleDataInput.readString();
            companiesDAO.findByName(name);
        } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
    }
}
