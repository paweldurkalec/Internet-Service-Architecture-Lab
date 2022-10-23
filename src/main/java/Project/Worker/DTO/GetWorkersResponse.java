package Project.Worker.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetWorkersResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Worker {

        private String name;

    }

    private List<Worker> workers;

    public static Function<Collection<Project.Worker.Entity.Worker>, GetWorkersResponse> entityToDtoMapper() {
        return Workers -> {
            GetWorkersResponseBuilder response = GetWorkersResponse.builder();
            List<Worker> wrks;
            wrks = Workers.stream()
                    .map(worker -> Worker.builder()
                            .name(worker.getName())
                            .build())
                    .toList();
            response.workers(wrks);
            return response.build();
        };
    }

}
