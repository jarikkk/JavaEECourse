package view;

import dao.SkillDaoImpl;
import entities.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSkillHibernate {

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Skill.class)
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            SkillDaoImpl skillDao = new SkillDaoImpl(sessionFactory);
            System.out.println("Method get is:" + skillDao.get(1));
        }
    }
}

