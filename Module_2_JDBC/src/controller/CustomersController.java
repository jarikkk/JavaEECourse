package controller;

import model.dao.CustomersDAO;
import model.dao.CustomersDAOImpl;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class CustomersController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        CustomersDAO customersDAO = new CustomersDAOImpl();
        int controlValue;
        int id;
        String name;

        ConsoleDataInput.writeMessage("----------------------CUSTOMERS CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL PROJECTS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleDataInput.readInt();

        if (controlValue == 1) {
            ConsoleDataInput.writeMessage("INPUT NAME OF CUSTOMER TO CREATE");
            name = ConsoleDataInput.readString();
            customersDAO.create(name);
        } else if (controlValue == 2) {
            ConsoleDataInput.writeMessage("INPUT ID TO DELETE CUSTOMER");
            id = ConsoleDataInput.readInt();
            customersDAO.delete(id);
        } else if (controlValue == 3) {
            ConsoleDataInput.writeMessage("INPUT NAME OF CUSTOMER TO UPDATE");
            name = ConsoleDataInput.readString();
            customersDAO.update(name);
        } else if (controlValue == 4) {
            customersDAO.getAll();
        } else if (controlValue == 5) {
            ConsoleDataInput.writeMessage("INPUT NAME OF CUSTOMER TO FIND");
            name = ConsoleDataInput.readString();
            customersDAO.findByName(name);
        } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
    }
}
