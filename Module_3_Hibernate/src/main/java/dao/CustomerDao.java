package dao;

import entities.Customer;

import java.util.List;

public interface CustomerDao<Customer> extends DAO<Customer> {
    public String findByName(String name);
    public List<Customer> getAll();
}
