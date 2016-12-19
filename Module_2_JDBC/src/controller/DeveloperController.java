package controller;

import model.dao.DevelopersDAO;
import model.dao.DevelopersDAOImpl;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class DeveloperController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        DevelopersDAO developersDAO = new DevelopersDAOImpl();
        int controlValue;
        int id;
        String name;

        ConsoleDataInput.writeMessage("----------------------DEVELOPERS CONSOLE---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL PROJECTS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleDataInput.readInt();

        if (controlValue == 1) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER TO CREATE");
            name = ConsoleDataInput.readString();
            developersDAO.create(name);
        } else if (controlValue == 2) {
            ConsoleDataInput.writeMessage("INPUT ID TO DELETE DEVELOPER");
            id = ConsoleDataInput.readInt();
            developersDAO.delete(id);
        } else if (controlValue == 3) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER TO UPDATE");
            name = ConsoleDataInput.readString();
            developersDAO.update(name);
        } else if (controlValue == 4) {
            developersDAO.getAll();
        } else if (controlValue == 5) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER TO FIND");
            name = ConsoleDataInput.readString();
            developersDAO.findByName(name);
        } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
    }
}
