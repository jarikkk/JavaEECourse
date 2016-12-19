package model.dao;

import model.entities.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asevruk on 12/7/2016.
 */
public class CompaniesDAOImpl implements CompaniesDAO<Company> {

    private static final String DB = "jdbc:postgresql://localhost:5433/test13";
    private static final String USER = "user1";
    private static final String PASS ="apppassword" ;
    private static  final String insertSql = "INSERT into Companies VALUES (?,?)";
    private static  final String selectById = "Select * from Companies where companie_id = ?";
    private static final String deleteSql = "DELETE from COMPANIES where companie_id  = ?  ";
    private static final String findByNameSql = "Select * from Companies where companie_name = ? ";
    private  static final String getAllSql  = "Select * from Companies";
    private  static final String updatetSql = "UPDATE Companies set companie_name = ? where companie_id = ?";

    PreparedStatement statement;





    @Override
    public void create(Company company) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(insertSql);
            statement.setInt(1,company.getCompanyID());
            statement.setString(2,company.getCompanyName());
            statement.executeQuery();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(DB,USER,PASS);
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Company get(int id) {
        String name = "";
        Company company = new Company(id,name);
        try {

            loadDriver();
            Connection connection = connectToDB();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(selectById);
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            company.setCompanyID(resultSet.getInt("companie_id"));
            company.setCompanyName(resultSet.getString("companie_name"));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void update(Company company) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(updatetSql);
            statement.setString(1,company.getCompanyName());
            statement.setInt(2,company.getCompanyID());
            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(deleteSql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Company findByName(String name) {
        int id;

        try {

            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(findByNameSql);
            statement.setString(1,name);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                id= resultSet.getInt("companie_id");
                name = (resultSet.getString("companie_name"));
                Company company = new Company(id,name);
                return company;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

      return null;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        try {
            loadDriver();
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllSql);
            while (resultSet.next()){
            int id = resultSet.getInt("companie_id");
             String name = resultSet.getString("companie_name") ;
              companies.add(new Company(id,name));
            }
        }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return companies;
    }
}
