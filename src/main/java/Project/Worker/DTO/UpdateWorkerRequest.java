package Project.Worker.DTO;

import Project.Worker.Entity.Worker;
import lombok.*;

import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateWorkerRequest {

    private int age;

    private String company;

    public static BiFunction<Worker, UpdateWorkerRequest, Worker> dtoToEntityUpdater() {
        return (worker, request) -> {
            worker.setAge(request.getAge());
            return worker;
        };
    }
}
