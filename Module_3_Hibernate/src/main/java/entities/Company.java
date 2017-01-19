package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies", schema = "public")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companie_id")
    private int companyID;

    @Column(name = "companie_name")
    private String companyName;

    @OneToMany(mappedBy = "projectCompanyId")
    private Set<Project> projects;

    @OneToMany(mappedBy = "developerCompanyId")
    private Set<Developer> developers;

    public Company() {

    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
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
                ", projects=" + projects +
                ", developers=" + developers +
                '}';
    }
}
