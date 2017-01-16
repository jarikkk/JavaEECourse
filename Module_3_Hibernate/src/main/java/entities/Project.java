package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projects", schema = "public")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "project_company_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "project_customer_id")
    private Project projectCustomerId;

    @Column(name = "project_start_timestamp")
    private Date projectTimeStamp;

    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Project getProjectCompanyId() {
        return project;
    }

    public void setProjectCompanyId(Company projectCompanyId) {
        this.project = project;
    }

    public Project getProjectCustomerId() {
        return projectCustomerId;
    }

    public void setProjectCustomerId(Project projectCustomerId) {
        this.projectCustomerId = projectCustomerId;
    }

    public Date getProjectTimeStamp() {
        return projectTimeStamp;
    }

    public void setProjectTimeStamp(Date projectTimeStamp) {
        this.projectTimeStamp = projectTimeStamp;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectCompanyId=" + project +
                ", projectCustomerId=" + projectCustomerId +
                ", projectTimeStamp=" + projectTimeStamp +
                '}';
    }
}
