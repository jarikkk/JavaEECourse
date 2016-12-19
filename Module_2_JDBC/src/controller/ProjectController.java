package controller;

import model.dao.ProjectDAO;
import model.dao.ProjectDAOImpl;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        ProjectDAO projectDAO = new ProjectDAOImpl();
        int controlValue;
        int id;
        String name;

        ConsoleDataInput.writeMessage("----------------------PROJECTS---------------------" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL PROJECTS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleDataInput.readInt();

        if (controlValue == 1) {
            ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO CREATE");
            name = ConsoleDataInput.readString();
            projectDAO.create(name);
        } else if (controlValue == 2) {
            ConsoleDataInput.writeMessage("INPUT ID TO DELETE PROJECT");
            id = ConsoleDataInput.readInt();
            projectDAO.delete(id);
        } else if (controlValue == 3) {
            ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO UPDATE");
            name = ConsoleDataInput.readString();
            projectDAO.update(name);
        } else if (controlValue == 4) {
            projectDAO.getAll();
        } else if (controlValue == 5) {
            ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO FIND");
            name = ConsoleDataInput.readString();
            projectDAO.findByName(name);
        } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
    }
}
