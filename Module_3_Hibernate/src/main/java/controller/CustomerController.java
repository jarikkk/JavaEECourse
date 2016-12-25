package controller;

import dao.CustomerDaoImpl;
import entities.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerController implements GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Customer customer = new Customer();
        int id;
        String name;
        int controlValue;


        Configuration configuration = new Configuration()
                .addAnnotatedClass(Customer.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            CustomerDaoImpl customerDao = new CustomerDaoImpl(sessionFactory);



            ConsoleDataInput.writeMessage("* * * CUSTOMERS * * *" + "\n" +
                    "1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL SKILLS | 5 - FIND BY NAME | 6 - GET BY ID\\n");

            controlValue = ConsoleDataInput.readInt();

            if (controlValue == 1) {
                ConsoleDataInput.writeMessage("INPUT NAME OF CUSTOMER TO CREATE");
                name = ConsoleDataInput.readString();
                customer.setCustomerName(name);
                customerDao.create(customer);
            } else if (controlValue == 2) {
                ConsoleDataInput.writeMessage("INPUT ID TO DELETE CUSTOMER");
                id = ConsoleDataInput.readInt();
                customerDao.delete(id);
            } else if (controlValue == 3) {
                ConsoleDataInput.writeMessage("INPUT NAME & ID OF CUSTOMER TO UPDATE");
                name = ConsoleDataInput.readString();
                id = ConsoleDataInput.readInt();
                customer.setCustomerId(id);
                customer.setCustomerName(name);
                customerDao.update(customer);
            } else if (controlValue == 4) {
                System.out.println(customerDao.getAll());
            } else if (controlValue == 5) {
                ConsoleDataInput.writeMessage("INPUT NAME OF CUSTOMER");
                name = ConsoleDataInput.readString();
                System.out.println(customerDao.findByName(name));
            } else if (controlValue == 6) {
                ConsoleDataInput.writeMessage("INPUT CUSTOMER ID TO GET SKILL");
                id = ConsoleDataInput.readInt();
                System.out.println(customerDao.get(id));
            }
            else System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");
        }

    }
}
