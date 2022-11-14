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
public class GetWorkerResponse {
    private String name;

    private int age;

    private String companyName;

    public static Function<Worker, GetWorkerResponse> entityToDtoMapper() {
        return Worker -> GetWorkerResponse.builder()
                .name(Worker.name)
                .age(Worker.age)
                .companyName(Worker.getCompany().getName())
                .build();
    }
}
