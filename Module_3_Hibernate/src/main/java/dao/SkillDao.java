package dao;


import java.util.List;

public interface SkillDao<Skill> extends DAO<Skill> {
    public String findByName(String name);
   public List<Skill> getAll();
}
