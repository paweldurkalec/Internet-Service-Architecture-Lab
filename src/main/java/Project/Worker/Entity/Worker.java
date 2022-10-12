package Project.Worker.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
public class Worker {

    public String name;

    public int age;

    public Company company;
}
