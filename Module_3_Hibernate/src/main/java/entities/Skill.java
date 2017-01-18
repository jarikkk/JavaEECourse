package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skills", schema = "public")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private int skillId;

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills", joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Developer> developers;

    public Skill() {
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }


    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", developers=" + developers +
                '}';
    }
}
