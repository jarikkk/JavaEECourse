package controller;


import dao.CompanyDaoImpl;
import entities.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class CompanyController implements GeneralController {

    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Company company = new Company();
        int id;
        String name;
        int controlValue;


        Configuration configuration = new Configuration()
                .addAnnotatedClass(Company.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            CompanyDaoImpl companyDAO = new CompanyDaoImpl(sessionFactory);



            ConsoleDataInput.writeMessage("* * * COMPANY * * *" + "\n" +
                    "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME | 6 - GET BY ID\\n");

            controlValue = ConsoleDataInput.readInt();

            if (controlValue == 1) {
                ConsoleDataInput.writeMessage("INPUT NAME OF COMPANY TO CREATE");
                name = ConsoleDataInput.readString();
                company.setCompanyName(name);
                companyDAO.create(company);
            } else if (controlValue == 2) {
                ConsoleDataInput.writeMessage("INPUT ID TO DELETE COMPANY");
                id = ConsoleDataInput.readInt();
                companyDAO.delete(id);
            } else if (controlValue == 3) {
                ConsoleDataInput.writeMessage("INPUT NAME & ID OF COMPANY TO UPDATE");
                name = ConsoleDataInput.readString();
                id = ConsoleDataInput.readInt();
                company.setCompanyID(id);
                company.setCompanyName(name);
                companyDAO.update(company);
            } else if (controlValue == 4) {
                System.out.println(companyDAO.getAll());
            } else if (controlValue == 5) {
                ConsoleDataInput.writeMessage("INPUT NAME OF COMPANY TO FIND SKILL");
                name = ConsoleDataInput.readString();
                System.out.println(companyDAO.findByName(name));
            } else if (controlValue == 6) {
                ConsoleDataInput.writeMessage("INPUT COMPANY ID TO GET COMPANY");
                id = ConsoleDataInput.readInt();
                System.out.println(companyDAO.get(id));
            }
            else System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");
        }

    }
}
