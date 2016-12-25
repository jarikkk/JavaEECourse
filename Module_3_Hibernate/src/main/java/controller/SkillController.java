package controller;

import dao.SkillDaoImpl;
import entities.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class SkillController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Skill skill1 = new Skill();
        int id;
        String name;
        int controlValue;


        Configuration configuration = new Configuration()
                .addAnnotatedClass(Skill.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            SkillDaoImpl skillDAO = new SkillDaoImpl(sessionFactory);



        ConsoleDataInput.writeMessage("* * * DEVELOPERS SKILLS * * *" + "\n" +
                "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME | 6 - GET BY ID\\n");

        controlValue = ConsoleDataInput.readInt();

        if (controlValue == 1) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER SKILL TO CREATE");
            name = ConsoleDataInput.readString();
            skill1.setSkillName(name);
            skillDAO.create(skill1);
        } else if (controlValue == 2) {
            ConsoleDataInput.writeMessage("INPUT ID TO DELETE DEVELOPER SKILL");
            id = ConsoleDataInput.readInt();
            skillDAO.delete(id);
        } else if (controlValue == 3) {
            ConsoleDataInput.writeMessage("INPUT ID & NAME OF DEVELOPER SKILL TO UPDATE");
            name = ConsoleDataInput.readString();
            id = ConsoleDataInput.readInt();
            skill1.setSkillId(id);
            skill1.setSkillName(name);
            skillDAO.update(skill1);
        } else if (controlValue == 4) {
            System.out.println(skillDAO.getAll());
        } else if (controlValue == 5) {
            ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER SKILL TO FIND SKILL");
            name = ConsoleDataInput.readString();
            System.out.println(skillDAO.findByName(name));
        } else if (controlValue == 6) {
            ConsoleDataInput.writeMessage("INPUT SKILL ID TO GET SKILL");
            id = ConsoleDataInput.readInt();
            System.out.println(skillDAO.get(id));
        }
        else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
        }

    }
}
