package Project.Company.Entity;

import Project.Worker.Entity.Worker;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="companies")
public class Company {

    @Id
    @Column(name="company_name")
    public String name;

    @Column(name="company_value")
    public int value;

    @Column(name="company_type")
    public String type;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "company")
    @ToString.Exclude
    List<Worker> workerList;
}
