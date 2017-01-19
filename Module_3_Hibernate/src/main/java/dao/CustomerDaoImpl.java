package dao;

import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class CustomerDaoImpl implements CustomerDao<Customer> {

    private SessionFactory sessionFactory;

    public CustomerDaoImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.save(customer);
        }
    }

    @Override
    public Customer get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    @Override
    public boolean update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(customer);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }

        }
    }

    @Override
    public boolean delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Customer customer = session.load(Customer.class, id);
                session.delete(customer);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
    @Override
    public String findByName(String name) {

        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Customer where name = :name").setParameter("name", name).toString();
        }
    }

    @Override
    public List<Customer> getAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("select customerId, customerName from Customer").list();
        }
    }
}
