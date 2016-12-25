package dao;

import entities.Company;


import java.util.List;


public interface CompanyDao<Company> extends DAO <Company> {

    public String findByName(String name);
    public List<Company> getAll();
}
