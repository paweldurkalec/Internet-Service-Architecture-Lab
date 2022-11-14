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
public class GetCompanyResponse {
    private String name;

    private int value;

    private String type;

    public static Function<Company, GetCompanyResponse> entityToDtoMapper() {
        return company -> GetCompanyResponse.builder()
                .name(company.name)
                .value(company.value)
                .type(company.type)
                .build();
    }
}
