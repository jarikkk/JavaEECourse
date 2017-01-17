package controller;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import entities.Company;
import entities.Customer;
import entities.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class ProjectController implements GeneralController {


    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        Project project = new Project();

        int id;
        String name;
        Date date;
        int controlValue;

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Project.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            ProjectDao projectDao = new ProjectDaoImpl(sessionFactory);

            ConsoleDataInput.writeMessage("* * * PROJECT * * *" + "\n" +
                    "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME | 6 - GET BY ID " + "\n");

            controlValue = ConsoleDataInput.readInt();

            if (controlValue == 1) {
                Company company = new Company();
                Customer customer = new Customer();
                ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO CREATE");
                name = ConsoleDataInput.readString();
                project.setProjectName(name);

                ConsoleDataInput.writeMessage("INPUT COMPANY ID OF PROJECT ");
                id = ConsoleDataInput.readInt();
                company.setCompanyID(id);
                project.setProjectCompanyId(company);

                ConsoleDataInput.writeMessage("INPUT CUSTOMER ID OF PROJECT ");
                id = ConsoleDataInput.readInt();
                customer.setCustomerId(id);
                project.setProjectCustomerId(customer);

                ConsoleDataInput.writeMessage("INPUT DATE OF CREATION OF PROJECT");
                date = ConsoleDataInput.readDate();
                project.setProjectTimeStamp(date);

                projectDao.create(project);

            } else if (controlValue == 2) {
                ConsoleDataInput.writeMessage("INPUT ID TO DELETE PROJECT");
                id = ConsoleDataInput.readInt();
                projectDao.delete(id);

            } else if (controlValue == 3) {
                Company company = new Company();
                Customer customer = new Customer();
                ConsoleDataInput.writeMessage("INPUT ID TO UPDATE PROJECT");
                id = ConsoleDataInput.readInt();
                project.setProjectId(id);

                ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO CREATE");
                name = ConsoleDataInput.readString();
                project.setProjectName(name);

                ConsoleDataInput.writeMessage("INPUT COMPANY ID OF PROJECT ");
                id = ConsoleDataInput.readInt();
                company.setCompanyID(id);
                project.setProjectCompanyId(company);


                ConsoleDataInput.writeMessage("INPUT CUSTOMER ID OF PROJECT ");
                id = ConsoleDataInput.readInt();
                customer.setCustomerId(id);
                project.setProjectCustomerId(customer);

                ConsoleDataInput.writeMessage("INPUT DATE OF CREATION OF PROJECT");
                date = ConsoleDataInput.readDate();
                project.setProjectTimeStamp(date);
                projectDao.update(project);

            } else if (controlValue == 4) {
                projectDao.getAll();

            } else if (controlValue == 5) {
                ConsoleDataInput.writeMessage("INPUT NAME OF PROJECT TO CREATE");
                name = ConsoleDataInput.readString();
                projectDao.findByName(name);
            } else if (controlValue == 6) {
                ConsoleDataInput.writeMessage("INPUT PROJECT ID TO GET PROJECT DATA");
                id = ConsoleDataInput.readInt();
                projectDao.get(id);
            } else System.out.println("You have entered not correct value. Input 1, 2, 3, 4 or 5.");
        }
    }
}
