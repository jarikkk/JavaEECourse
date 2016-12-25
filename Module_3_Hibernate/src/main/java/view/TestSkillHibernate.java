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
           // System.out.println("Method get is:" + skillDao.get(1));
//            Skill skill = new Skill();
//            Skill skill11 = new Skill();
//            skill.setSkillId(2);
//            skill.setSkillName("testnamehibernate");
//            skill11.setSkillName("testnamehibernate2");
//           skillDao.create(skill11);
//            skillDao.update(skill);
            System.out.println(skillDao.getAll());
            System.out.println(skillDao.findByName("q").toString());
        }
    }
}

