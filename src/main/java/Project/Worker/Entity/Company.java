package Project.Worker.Entity;

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

    @OneToMany(mappedBy="company", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
    List<Worker> workerList;
}
