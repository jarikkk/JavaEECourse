package dao;


import java.util.List;

public interface DeveloperDao<Developer> extends DAO<Developer> {
    public String findByName(String name);
    public List<Developer> getAll();
}
