package model.dao;

import model.entities.Customer;
import utilities.ConnectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO<Customer> {

    @Override
    public void create(Customer customer) {
        try {
            ConnectionUtils.PrepearedStatementcreateCustomers("INSERT INTO CUSTOMERS (customer_name) VALUES (?)", customer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer get(int id) {
        String resultName = "";
        Customer customer = new Customer(id, resultName);
        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementGet("SELECT * FROM CUSTOMERS WHERE customer_id = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("customer_id");
                resultName = resultSet.getString("customer_name");
            }
            customer.setCustomerId(id);
            customer.setCustomerName(resultName);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            ConnectionUtils.PrepearedStatementcreateCustomers("UPDATE CUSTOMERS SET customer_name = ?", customer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            ConnectionUtils.PrepearedStatementdelete("DELETE FROM CUSTOMERS WHERE customer_id = ?", id);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findByName(String name) {
        String resultName = "";
        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementFindbyName("SELECT customer_name FROM CUSTOMERS WHERE customer_name = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("customer_name");
            }
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultName;
    }


    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer(0, null);
        int id = 0;
        String name = "";
        try {
            ResultSet resultSet = ConnectionUtils.performStatement("select * from CUSTOMERS");
            while (resultSet.next()) {
                id = resultSet.getInt("customer_id");
                name = resultSet.getString("customer_name");
                customer.setCustomerId(id);
                customer.setCustomerName(name);
                customers.add(customer);
            }
            ConnectionUtils.closeStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }

}
