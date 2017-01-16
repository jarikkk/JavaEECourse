package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills", schema = "public")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private int skillId;

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
            schema = "public",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skillsList;

    public Skill() {
    }

    public Skill(int skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
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
                '}';
    }
}
