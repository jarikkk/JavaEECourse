package dao;

import entities.Project;

import java.util.List;

public interface ProjectDao<Project> extends DAO<Project> {
    public String findByName(String name);
    public List<Project> getAll();
}
