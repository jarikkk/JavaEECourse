package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name = "developer_join_date")
    private Date developerJoinDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
            schema = "public",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Skill> skillsList;

    public Developer() {

    }

    public Developer(int developerId, String developerName, Company developerCompanyId, Project developerProjectId, Date developerJoinDate) {
        this.developerId = developerId;
        this.developerName = developerName;
        this.developerCompanyId = developerCompanyId;
        this.developerProjectId = developerProjectId;
        this.developerJoinDate = developerJoinDate;
    }

    public Developer(String developerName) {
        this.developerName = developerName;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", developerName='" + developerName + '\'' +
                ", developerCompanyId=" + developerCompanyId +
                ", developerProjectId=" + developerProjectId +
                ", developerJoinDate=" + developerJoinDate +
                '}';
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


}
