package controller;

import model.dao.SkillDAO;
import model.dao.SkillDAOImpl;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class SkillController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        SkillDAO skillDAO = new SkillDAOImpl();
        int id;
        String name;
        int controlValue;

        ConsoleDataInput.writeMessage("* * * DEVELOPERS SKILLS * * *" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME\\n");

        controlValue = ConsoleDataInput.readInt();

        if (controlValue == 1) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER SKILL TO CREATE");
            name = ConsoleDataInput.readString();
            skillDAO.create(name);
        } else if (controlValue == 2) {
            ConsoleDataInput.writeMessage("INPUT ID TO DELETE DEVELOPER SKILL");
            id = ConsoleDataInput.readInt();
            skillDAO.delete(id);
        } else if (controlValue == 3) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER SKILL TO UPDATE");
            name = ConsoleDataInput.readString();
            skillDAO.update(name);
        } else if (controlValue == 4) {
            skillDAO.getAll();
        } else if (controlValue == 5) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER SKILL TO FIND SKILL");
            name = ConsoleDataInput.readString();
            skillDAO.findByName(name);
        } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");

    }
}
