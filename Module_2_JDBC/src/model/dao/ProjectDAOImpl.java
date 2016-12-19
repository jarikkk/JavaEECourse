package model.dao;

import model.entities.Company;
import model.entities.Customer;
import model.entities.Developer;
import model.entities.Project;
import utilities.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asevruk on 12/9/2016.
 */
public class ProjectDAOImpl implements ProjectDAO<Project> {


    @Override
    public void create(Project project) {
        try {
            ConnectionUtils.PrepearedStatementcreateProject("INSERT INTO PROJECTS (project_name) VALUES (?)", project);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project get(int id) {
        String resultName = "";
        Project project = new Project(id, null, null, null, null);
        Company companyId = project.getProjectCompanyId();
        Customer customerId = project.getProjectCustomerId();
        int companyID = 0;
        int customerID = 0;
        Date date = null;
        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementGet("SELECT * FROM PROJECTS WHERE project_id = ?", id);

            while (resultSet.next()) {
                id = resultSet.getInt("project_id");
                resultName = resultSet.getString("project_name");
                companyID = resultSet.getInt("project_company_id");
                companyId.setCompanyID(companyID);
                customerID = resultSet.getInt("project_customer_id");
                customerId.setCustomerId(customerID);
                date = resultSet.getDate("project_time_stamp");

            }
            project.setProjectId(id);
            project.setProjectName(resultName);
            project.setProjectCompanyId(companyId);
            project.setProjectCustomerId(customerId);
            project.setProjectTimeStamp(date);


            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;

    }

    @Override
    public void update(Project project) {
        try {
            ConnectionUtils.PrepearedStatementcreateProject("UPDATE PROJECTS SET project_name = ?", project);
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
            ConnectionUtils.PrepearedStatementdelete("DELETE * FROM PROJECTS WHERE project_id=?", id);
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
            ResultSet resultSet = ConnectionUtils.PrepearedStatementFindbyName("SELECT projectName FROM PROJECTS WHERE projectName= ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("project_name");
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
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        Project project = new Project(0, null, null, null, null);
        Company companyId = project.getProjectCompanyId();
        Customer customerId=project.getProjectCustomerId();
        int id = 0;
        String resultName = "";
        int companyID = 0;
        int customerID = 0;
        Date date = null;
        try {
            ResultSet resultSet = ConnectionUtils.performStatement("SELECT * FROM PROJECTS");
            while (resultSet.next()) {
                id = resultSet.getInt("project_id");
                resultName = resultSet.getString("project_name");
                companyID = resultSet.getInt("developer_company_id");
                companyId.setCompanyID(companyID);
                customerID = resultSet.getInt("customer_project_id");
                customerId.setCustomerId(customerID);
                date = resultSet.getDate("project_time_stamp");

                project.setProjectId(id);
                project.setProjectName(resultName);
                project.setProjectCompanyId(companyId);
                project.setProjectCustomerId(customerId);
                project.setProjectTimeStamp(date);



                projects.add(project);
            }
            ConnectionUtils.closeStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return projects;
    }


}
