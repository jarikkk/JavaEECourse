package controller;

import dao.DeveloperDao;
import dao.DeveloperDaoImpl;
import entities.Company;
import entities.Customer;
import entities.Developer;
import entities.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class DeveloperController implements GeneralController {

    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        Developer developer = new Developer();

        int id;
        String name;
        Date date;
        int controlValue;

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Project.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            DeveloperDao developerDao = new DeveloperDaoImpl(sessionFactory);
            ConsoleDataInput.writeMessage("* * * PROJECT * * *" + "\n" +
                    "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME | 6 - GET BY ID " + "\n");

            controlValue = ConsoleDataInput.readInt();

            if (controlValue == 1) {
                Company company = new Company();
                Project project = new Project();
                ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER TO CREATE");
                name = ConsoleDataInput.readString();
                developer.setDeveloperName(name);

                ConsoleDataInput.writeMessage("INPUT COMPANY ID OF DEVELOPER ");
                id = ConsoleDataInput.readInt();
                company.setCompanyID(id);
                developer.setDeveloperCompanyId(company);


                ConsoleDataInput.writeMessage("INPUT PROJECT ID OF DEVELOPER ");
                id = ConsoleDataInput.readInt();
                project.setProjectId(id);
                developer.setDeveloperProjectId(project);

                ConsoleDataInput.writeMessage("INPUT DATE OF DEVELOPER JOIN");
                date = ConsoleDataInput.readDate();
                developer.setDeveloperJoinDate(date);

                developerDao.create(developer);

            } else if (controlValue == 2) {
                ConsoleDataInput.writeMessage("INPUT ID TO KILL DEVELOPER");
                id = ConsoleDataInput.readInt();
                developerDao.delete(id);

            } else if (controlValue == 3) {
                Company company = new Company();
                Project project = new Project();
                ConsoleDataInput.writeMessage("INPUT ID TO UPDATE PROJECT");
                id = ConsoleDataInput.readInt();
                developer.setDeveloperId(id);

                ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER TO UPDATE");
                name = ConsoleDataInput.readString();
                developer.setDeveloperName(name);

                ConsoleDataInput.writeMessage("INPUT COMPANY ID OF DEVELOPER");
                id = ConsoleDataInput.readInt();
                company.setCompanyID(id);
                developer.setDeveloperCompanyId(company);


                ConsoleDataInput.writeMessage("INPUT PROJECT ID OF DEVELOPER");
                id = ConsoleDataInput.readInt();
                project.setProjectId(id);
                developer.setDeveloperProjectId(project);

                ConsoleDataInput.writeMessage("INPUT DATE OF DEVELOPER JOIN");
                date = ConsoleDataInput.readDate();
                developer.setDeveloperJoinDate(date);

                developerDao.update(developer);

            } else if (controlValue == 4) {
                developerDao.getAll();

            } else if (controlValue == 5) {
                ConsoleDataInput.writeMessage("INPUT NAME OF DEVELOPER TO FIND");
                name = ConsoleDataInput.readString();
                developerDao.findByName(name);
            } else if (controlValue == 6) {
                ConsoleDataInput.writeMessage("INPUT DEVELOPER ID TO GET DEVELOPER DATA");
                id = ConsoleDataInput.readInt();
                developerDao.get(id);
            } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
        }
    }
}
