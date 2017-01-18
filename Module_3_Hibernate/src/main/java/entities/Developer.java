package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.Set;

@Entity
@Table(name = "developers", schema = "public")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private int developerId;

    @Column(name = "developer_name")
    private String developerName;

    @ManyToOne
    @JoinColumn(name = "developer_company_id")
    private Company developerCompanyId;

    @ManyToOne
    @JoinColumn(name = "developer_project_id")
    private Project developerProjectId;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "developers")
    private List<Skill> skills;

    @Column(name = "developer_join_date")
    private Date developerJoinDate;


    public Developer() {

    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Developer(String developerName) {
        this.developerName = developerName;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Company getDeveloperCompanyId() {
        return developerCompanyId;
    }

    public void setDeveloperCompanyId(Company developerCompanyId) {
        this.developerCompanyId = developerCompanyId;
    }

    public Project getDeveloperProjectId() {
        return developerProjectId;
    }

    public void setDeveloperProjectId(Project developerProjectId) {
        this.developerProjectId = developerProjectId;
    }

    public Date getDeveloperJoinDate() {
        return developerJoinDate;
    }

    public void setDeveloperJoinDate(Date developerJoinDate) {
        this.developerJoinDate = developerJoinDate;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", developerName='" + developerName + '\'' +
                ", developerCompanyId=" + developerCompanyId +
                ", developerProjectId=" + developerProjectId +
                ", skills=" + skills +
                ", developerJoinDate=" + developerJoinDate +
                '}';
    }
}
