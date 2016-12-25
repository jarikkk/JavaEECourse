import controller.GeneralController;
import controller.SkillController;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class Run {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        GeneralController generalController = null;
        int controlValue;
        ConsoleDataInput.writeMessage("Welcome to CRUD System-----------------------------------------------");

while (true) {
    ConsoleDataInput.writeMessage("\\nPlease Choose Entity: 1 - SKILL | 2 - DEVELOPER | 3 - PROJECT | 4 - COMPANY | 5 - EXIT FROM SYSTEM");
    controlValue = ConsoleDataInput.readInt();
    switch (controlValue) {
        case 1:
            generalController = new SkillController();
            generalController.execute();
    }
}
    }
}
