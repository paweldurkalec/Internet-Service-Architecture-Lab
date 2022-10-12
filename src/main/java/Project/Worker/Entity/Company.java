package Project.Worker.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
public class Company {

    public String name;

    public int value;

    public String type;
}
