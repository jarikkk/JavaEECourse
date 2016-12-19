package model.dao;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface CustomersDAO<Customer> extends DAO<Customer> {

   public String findByName(String name);
   public List<Customer> getAll();

}
