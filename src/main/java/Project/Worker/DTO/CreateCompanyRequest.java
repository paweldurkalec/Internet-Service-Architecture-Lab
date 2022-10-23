package Project.Worker.DTO;


import Project.Worker.Entity.Company;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateCompanyRequest {

    private String name;

    private int value;

    private String type;

    public static Function<CreateCompanyRequest, Company> dtoToEntityMapper(){
        return request -> Company.builder()
                .name(request.getName())
                .value(request.getValue())
                .type(request.getType())
                .build();
    }

}
