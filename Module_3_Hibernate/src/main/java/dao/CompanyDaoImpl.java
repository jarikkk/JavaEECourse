package dao;

import entities.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao<Company> {
    private SessionFactory sessionFactory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Company company) {
        try (Session session = sessionFactory.openSession()) {
            session.save(company);
        }
    }

    @Override
    public Company get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Company.class, id);
        }
    }

    @Override
    public boolean update(Company company) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(company);
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
                Company company = session.load(Company.class, id);
                session.delete(company);
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
            return session.createQuery("from Company where name = :name").setParameter("name", name).toString();
        }
    }

    @Override
    public List<Company> getAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Company", Company.class).list();
        }
    }
}
