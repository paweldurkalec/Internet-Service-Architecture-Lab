package Project.Company.DTO;


import Project.Company.Entity.Company;
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

    public static Function<CreateCompanyRequest, Company> dtoToEntityMapper(){
        return request -> Company.builder()
                .name(request.getName())
                .build();
    }

}
