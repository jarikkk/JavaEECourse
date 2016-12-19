package model.dao;

import java.util.List;

/**
 * Created by asevruk on 12/7/2016.
 */
public interface CompaniesDAO<Company> extends DAO<Company>{
    public Company findByName(String name);
    public List<Company> getAll();
}
