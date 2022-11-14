package Project.Company.DTO;

import Project.Company.Entity.Company;
import lombok.*;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateCompanyRequest {

    private int value;

    private String type;

    public static BiFunction<Company, UpdateCompanyRequest, Company> dtoToEntityUpdater() {
        return (company, request) -> {
            company.setValue(request.getValue());
            company.setType(request.getType());
            return company;
        };
    }
}
