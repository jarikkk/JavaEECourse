import controller.*;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class Run {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        GeneralController generalController = null;
        int controlValue;
        ConsoleDataInput.writeMessage("Welcome to CRUD System-----------------------------------------------");

while (true) {
    ConsoleDataInput.writeMessage("Please Choose Entity: 1 - SKILL | 2 - CUSTOMER | 3 - COMPANY | 4 - DEVELOPER | 5 - PROJECT | 6 - EXIT FROM SYSTEM");
    controlValue = ConsoleDataInput.readInt();
    switch (controlValue) {
        case 1:
            generalController = new SkillController();
            generalController.execute();
        case 2:
            generalController = new CustomerController();
            generalController.execute();
        case 3:
            generalController = new CompanyController();
            generalController.execute();
        case 4:
            generalController = new DeveloperController();
            generalController.execute();
        case 5:
            generalController = new ProjectController();
            generalController.execute();
        case 6:
            System.out.println("EXIT FROM SYSTEM");


    }
}
    }
}
