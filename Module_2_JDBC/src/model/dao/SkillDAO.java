package model.dao;
import java.util.List;

public interface SkillDAO<Skill> extends DAO<Skill> {
    public String findByName(String name);
    public List<Skill> getAll();
}
