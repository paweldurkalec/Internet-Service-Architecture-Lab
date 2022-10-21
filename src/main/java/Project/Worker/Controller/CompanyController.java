package Project.Worker.Controller;

//import Project.Worker.DTO.GetCompaniesResponse;
import Project.Worker.DTO.CreateCompanyRequest;
import Project.Worker.DTO.GetCompanyResponse;
import Project.Worker.Entity.Company;
import Project.Worker.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service){
        this.service = service;
    }

    @GetMapping("{name}")
    public ResponseEntity<GetCompanyResponse> getCharacter(@PathVariable("name") String name) {
        return service.find(name)
                .map(value -> ResponseEntity
                        .ok(GetCompanyResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    /*@GetMapping
    public ResponseEntity<GetCompaniesResponse> getCompanies() {
        return ResponseEntity
                .ok(GetCompaniesResponse.entityToDtoMapper().apply(service.findAll()));
    }*/

    @PostMapping
    public ResponseEntity<Void> createCompany(@RequestBody CreateCompanyRequest request, UriComponentsBuilder builder) {
        Company company = CreateCompanyRequest
                .dtoToEntityMapper(name -> service.find(name).orElseThrow(), () -> null)
                .apply(request);
        company = service.create(company);
        return ResponseEntity
                .created(builder
                        .pathSegment("api", "characters", "{id}")
                        .buildAndExpand(company.getId()).toUri())
                .build();
    }

}
