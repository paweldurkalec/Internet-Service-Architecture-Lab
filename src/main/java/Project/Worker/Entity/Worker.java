package Project.Worker.Entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @Column(name="worker_name")
    public String name;

    @Column(name="worker_age")
    public int age;

    @ManyToOne
    @JoinColumn(name="worker")
    public Company company;
}
