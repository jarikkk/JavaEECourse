package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies", schema = "public")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companie_id")
    private int companyID;

    @Column(name = "companie_name")
    private String companyName;

    @OneToMany(mappedBy = "project")
    private List<Company> project;

    public Company() {

    }

    public List<Company> getProject() {
        return project;
    }

    public void setProject(List<Company> project) {
        this.project = project;
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
