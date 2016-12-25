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
try(Session session = sessionFactory.openSession()){
    session.save(skill);
}
    }

    @Override
    public Skill get(int id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Skill.class, id);
        }
    }

    @Override
    public void update(Skill skill) {
        try(Session session = sessionFactory.openSession()){
           session.createQuery("UPDATE SKILLS SET skill_name = :skillName").setParameter("skillName", skill.getSkillName());
        }
    }

    @Override
    public void delete(int id) {
        try(Session session = sessionFactory.openSession()){
            session.createQuery("DELETE SKILLS WHERE skillId = :skillId").setParameter("skillId", id);
        }
    }

    @Override
    public String findByName(String name) {
        return null;
    }

    @Override
    public List<Skill> getAll() {
        return null;
    }
}
