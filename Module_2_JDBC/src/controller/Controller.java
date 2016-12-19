package controller;

import model.dao.*;
import model.entities.*;
import view.ConsoleDataInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    SkillDAOImpl skillDAOImpl;
    CustomersDAOImpl customersDAOimpl;
    CompaniesDAOImpl companiesDAOimpl;
    DevelopersDAOImpl developersDAOimpl;
    ProjectDAOImpl projectDAOimpl;

    public Controller(SkillDAOImpl skillDAOImpl, CustomersDAOImpl customersDAOimpl, CompaniesDAOImpl companiesDAOimpl, DevelopersDAOImpl developersDAOimpl, ProjectDAOImpl projectDAOimpl) {
        this.skillDAOImpl = skillDAOImpl;
        this.customersDAOimpl = customersDAOimpl;
        this.companiesDAOimpl = companiesDAOimpl;
        this.developersDAOimpl = developersDAOimpl;
        this.projectDAOimpl = projectDAOimpl;
    }

    public void createSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.create(skill);
    }
    public void createCustomersDB(CustomersDAOImpl customersDAOimpl) throws IOException{
        Customer customer=new Customer(ConsoleDataInput.readString());
        customersDAOimpl.create(customer);
    }
    public void createCompaniesDB(CompaniesDAOImpl companiesDAOimpl) throws IOException{
        Company company=new Company(ConsoleDataInput.readString());
        companiesDAOimpl.create(company);
    }
    public void createDeveloperDB(DevelopersDAOImpl developersDAOimpl) throws IOException{
        Developer developer=new Developer(ConsoleDataInput.readString());
        developersDAOimpl.create(developer);
    }
    public void createProject(ProjectDAOImpl projectDAOimpl) throws IOException{
        Project project=new Project(ConsoleDataInput.readString());
        projectDAOimpl.create(project);
    }


    public void updateCustomersDB() throws IOException{
        Customer customer=new Customer(ConsoleDataInput.readString());
        customersDAOimpl.update(customer);
    }
    public void updateCompaniesDB() throws IOException{
        Company company=new Company(ConsoleDataInput.readString());
        companiesDAOimpl.update(company);
    }
    public void updateDeveloperDB() throws IOException{
        Developer developer=new Developer(ConsoleDataInput.readString());
        developersDAOimpl.update(developer);
    }
    public void updateProject() throws IOException {
        Project project = new Project(ConsoleDataInput.readString());
        projectDAOimpl.update(project);
    }
    public void updateSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.update(skill);
    }







    public Company getcompanyDB() throws IOException {
       Company company = companiesDAOimpl.get(ConsoleDataInput.readInt());
        return company;
    }

    public Customer getCustomerDB() throws IOException {
       Customer customer = customersDAOimpl.get(ConsoleDataInput.readInt());
        return customer;
    }

    public Developer getDeveloperDB() throws IOException {
        Developer developer = developersDAOimpl.get(ConsoleDataInput.readInt());
        return developer;
    }

    public Project getProjectDB() throws IOException {
        Project project = projectDAOimpl.get(ConsoleDataInput.readInt());
        return project;
    }

    public Skill getSkillDB() throws IOException {
        Skill skill = skillDAOImpl.get(ConsoleDataInput.readInt());
        return skill;
    }

    public void deleteCompanyFromDb() throws IOException {
        companiesDAOimpl.delete(ConsoleDataInput.readInt());
    }
    public void deleteCustomerFromDb() throws IOException {
        customersDAOimpl.delete(ConsoleDataInput.readInt());
    }
    public void deleteDeveloperFromDb() throws IOException {
        developersDAOimpl.delete(ConsoleDataInput.readInt());
    }
    public void deleteProjectFromDb() throws IOException {
        projectDAOimpl.delete(ConsoleDataInput.readInt());
    }

    public void deleteSkillFromDb() throws IOException {
        skillDAOImpl.delete(ConsoleDataInput.readInt());
    }




    public Developer findByNameDeveloperDB() throws IOException {
        Developer developer=new Developer(developersDAOimpl.findByName(ConsoleDataInput.readString()));
        return developer;
    }
    public Customer findByNameCustomerDB() throws IOException{
        Customer customer=new Customer(customersDAOimpl.findByName(ConsoleDataInput.readString()));
        return customer;
    }

    public Project findByNameprojectDB() throws IOException{
        Project project=new Project(projectDAOimpl.findByName(ConsoleDataInput.readString()));
        return project;
    }


//    public Company findbyCompanyDB() throws IOException{
//        Company company=new Company(companiesDAOimpl.findByName(ConsoleDataInput.readString()));
//        return company;
//    }

    public Skill findByNameSkillDB() throws IOException {
        Skill skill = new Skill(skillDAOImpl.findByName(ConsoleDataInput.readString()));
        return skill;
    }




    public List<Company> getAllcompanyFromDb() throws IOException {
        List<Company> companies = new ArrayList<>();
        return companies = companiesDAOimpl.getAll();
    }


    public List<Customer> getAllCustomerFromDb() throws IOException {
    List<Customer> customers = new ArrayList<>();
    return customers = customersDAOimpl.getAll();
    }

    public List<Developer> getAllDeveloperFromDb() throws IOException {
        List<Developer> developers = new ArrayList<>();
        return developers = developersDAOimpl.getAll();
    }

    public List<Project> getAllprojcetFromDb() throws IOException {
        List<Project> projects = new ArrayList<>();
        return projects = projectDAOimpl.getAll();
    }


    public List<Skill> getAllSkillsFromDb() throws IOException {
        List<Skill> skills = new ArrayList<>();
        return skills = skillDAOImpl.getAll();
    }

}
