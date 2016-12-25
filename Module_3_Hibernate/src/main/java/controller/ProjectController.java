package controller;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import entities.Company;
import entities.Project;
import entities.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectController implements GeneralController {


    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Project project = new Project();
        Company company = new Company();;
        int id;
        String name;
        int controlValue;

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Project.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            ProjectDao projectDao = new ProjectDaoImpl(sessionFactory);

            ConsoleDataInput.writeMessage("* * * PROJECT * * *" + "\n" +
                    "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME | 6 - GET BY ID\\n");

            controlValue = ConsoleDataInput.readInt();

            if (controlValue == 1) {
                ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO CREATE");
                name = ConsoleDataInput.readString();
                project.setProjectName(name);

                ConsoleDataInput.writeMessage("");
                Company companyId = project.getProjectCompanyId();
                project.setProjectCompanyId(companyId);

                projectDao.create(project);
            }
        }
    }
}
