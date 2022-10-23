package Project.Worker.DTO;


import Project.Worker.Entity.Worker;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateWorkerRequest {

    private String name;

    private int age;

    private String company;

    public static Function<CreateWorkerRequest, Worker> dtoToEntityMapper(){
        return request -> Worker.builder()
                .name(request.getName())
                .age(request.getAge())
                .build();
    }

}
