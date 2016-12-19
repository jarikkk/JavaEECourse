package model.dao;


import model.entities.Company;
import model.entities.Developer;
import model.entities.Project;
import utilities.ConnectionUtils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DevelopersDAOImpl implements DevelopersDAO<Developer> {

    @Override
    public void create(Developer developer) {
        try {
            ConnectionUtils.PrepearedStatementcreateDeveloper("INSERT INTO DEVELOPERS (developerName) VALUES (?)", developer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer get(int id) {
        String resultName = "";
        Developer developer = new Developer(id, null, null, null, null);
        Company companyId = developer.getDeveloperCompanyId();
        Project projectId = developer.getDeveloperProjectId();
        int companyID = 0;
        int projectID = 0;
        Date date = null;

        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementGet("SELECT * FROM DEVELOPERS WHERE developer_id = ?", id);

            while (resultSet.next()) {
                id = resultSet.getInt("developer_id");
                resultName = resultSet.getString("developer_name");
                companyID = resultSet.getInt("developer_company_id");
                companyId.setCompanyID(companyID);
                projectID = resultSet.getInt("developer_project_id");
                projectId.setProjectId(projectID);
                date = resultSet.getDate("developer_join_date");

            }

            developer.setDeveloperId(id);
            developer.setDeveloperName(resultName);
            developer.setDeveloperCompanyId(companyId);
            developer.setDeveloperProjectId(projectId);
            developer.setDeveloperJoinDate(date);

            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void update(Developer developer) {
        try {
            ConnectionUtils.PrepearedStatementcreateDeveloper("UPDATE DEVELOPERS SET developer_name = ?", developer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            ConnectionUtils.PrepearedStatementdelete("DELETE * FROM DEVELOPERS WHERE developer_id=?", id);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String findByName(String name) {
        String resultName = "";
        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementFindbyName("SELECT developer_name FROM DEVELOPERS WHERE developer_name = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("developer_name");
            }
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultName;
    }

    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();
        Developer developer = new Developer(0, null, null, null, null);
        Company companyId = developer.getDeveloperCompanyId();
        Project projectId = developer.getDeveloperProjectId();
        int id = 0;
        String resultName = "";
        int companyID = 0;
        int projectID = 0;
        Date date = null;
        try {
            ResultSet resultSet = ConnectionUtils.performStatement("select * from DEVELOPERS");
            while (resultSet.next()) {
                id = resultSet.getInt("developer_id");
                resultName = resultSet.getString("developer_name");
                companyID = resultSet.getInt("developer_company_id");
                companyId.setCompanyID(companyID);
                projectID = resultSet.getInt("developer_project_id");
                projectId.setProjectId(projectID);
                date = resultSet.getDate("developer_join_date");

                developer.setDeveloperId(id);
                developer.setDeveloperName(resultName);
                developer.setDeveloperCompanyId(companyId);
                developer.setDeveloperProjectId(projectId);
                developer.setDeveloperJoinDate(date);

                developers.add(developer);
            }
            ConnectionUtils.closeStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return developers;
    }
}


