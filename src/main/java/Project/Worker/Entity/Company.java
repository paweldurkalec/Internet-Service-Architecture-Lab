package Project.Worker.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
