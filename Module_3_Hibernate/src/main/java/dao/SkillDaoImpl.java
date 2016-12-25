package dao;

import entities.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SkillDaoImpl implements SkillDao<Skill> {

    private SessionFactory sessionFactory;

    public SkillDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            session.save(skill);
        }
    }

    @Override
    public Skill get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Skill.class, id);
        }
    }

    @Override
    public boolean update(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(skill);
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
                Skill skill = session.load(Skill.class, id);
                session.delete(skill);
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
            return session.createQuery("from Skill where name = :name").setParameter("name", name).toString();
        }
    }

    @Override
    public List<Skill> getAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Skill", Skill.class).list();
        }
    }
}
