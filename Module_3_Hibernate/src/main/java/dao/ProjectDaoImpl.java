package dao;

import entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProjectDaoImpl implements ProjectDao<Project> {

    private SessionFactory sessionFactory;

    public ProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Project project) {
        try (Session session = sessionFactory.openSession()) {
            session.save(project);
        }
    }

    @Override
    public Project get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, id);
        }
    }

    @Override
    public boolean update(Project project) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(project);
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
                Project project = session.load(Project.class, id);
                session.delete(project);
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
            return session.createQuery("from Project where name = :name").setParameter("name", name).toString();
        }
    }

    @Override
    public List<Project> getAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("select from Project", Project.class).list();
        }
    }
}
