package jpabook.start;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "TEST_TEAM")
public class TestTeam {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<TestMember> members = new ArrayList<TestMember>();

    public void addMember(TestMember member) {
        this.members.add(member);
        if (member.getTeam() != this) {  //무한루프에 빠지지 않도록 체크
            member.setTeam(this);
        }
    }

    @Override
    public String toString() {
        return "TestTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
