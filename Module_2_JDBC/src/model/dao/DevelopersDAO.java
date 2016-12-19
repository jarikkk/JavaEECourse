package model.dao;



import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface DevelopersDAO<Developer> extends DAO<Developer> {
    String findByName(String name);
    public List<Developer> getAll();
}
