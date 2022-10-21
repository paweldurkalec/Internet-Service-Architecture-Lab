/*package Project.Worker.DTO;

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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @Singular
    private List<Company> companies;

    public static Function<Collection<Project.Worker.Entity.Company>, GetCompaniesResponse> entityToDtoMapper() {
        return companies -> {
          GetCompaniesResponseBuilder response = GetCompaniesResponse.builder();
          companies.stream()
                  .map(company -> Company.builder()
                          .name(company.getName())
                          .build())
                  .forEach(response::company);
          return response.build();
        };
    }

}*/
