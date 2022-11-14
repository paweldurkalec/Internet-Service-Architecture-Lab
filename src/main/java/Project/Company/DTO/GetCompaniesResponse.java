package Project.Company.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class GetCompaniesResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Company {

        private String name;

    }

    private List<Company> companies;

    public static Function<Collection<Project.Company.Entity.Company>, GetCompaniesResponse> entityToDtoMapper() {
        return companies -> {
            GetCompaniesResponseBuilder response = GetCompaniesResponse.builder();
            List<Company> cmps;
            cmps = companies.stream()
                    .map(company -> Company.builder()
                            .name(company.getName())
                            .build())
                    .toList();
            response.companies(cmps);
            return response.build();
        };
    }

}
