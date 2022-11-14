package Project.Company.Event.dto;

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
public class PostCompanyRequest {

    /**
     * User's login.
     */
    private String name;

    /**
     * @return mapper for convenient converting dto object to entity object
     */
    public static Function<Company, PostCompanyRequest> entityToDtoMapper() {
        return entity -> PostCompanyRequest.builder()
                .name(entity.getName())
                .build();
    }

}
