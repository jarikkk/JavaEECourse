package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies", schema = "public")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companie_id")
    private int companyID;

    @Column(name = "companie_name")
    private String companyName;

    @OneToMany(mappedBy = "company")
    private ArrayList<Project> projects = new ArrayList<>();

    public Company() {

    }

    public List<Project> getProject() {
        return this.projects;}


    public void setProject(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
