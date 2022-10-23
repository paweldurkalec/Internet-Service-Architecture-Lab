package Project.Worker.Controller;

//import Project.Worker.DTO.GetCompaniesResponse;
import Project.Worker.DTO.CreateCompanyRequest;
import Project.Worker.DTO.GetCompaniesResponse;
import Project.Worker.DTO.GetCompanyResponse;
import Project.Worker.DTO.UpdateCompanyRequest;
import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import Project.Worker.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service){
        this.service = service;
    }

    @GetMapping("{name}")
    public ResponseEntity<GetCompanyResponse> getCompany(@PathVariable("name") String name) {
        return service.find(name)
                .map(value -> ResponseEntity
                        .ok(GetCompanyResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @GetMapping
    public ResponseEntity<GetCompaniesResponse> getCompanies() {
        return ResponseEntity
                .ok(GetCompaniesResponse.entityToDtoMapper().apply(service.findAll()));
    }

    @PostMapping
    public ResponseEntity<Void> createCompany(@RequestBody CreateCompanyRequest request, UriComponentsBuilder builder) {
        Company company = CreateCompanyRequest
                .dtoToEntityMapper()
                .apply(request);
        service.create(company);
        return ResponseEntity
                .created(builder
                        .pathSegment("api", "companies", "{name}")
                        .buildAndExpand(company.getName()).toUri())
                .build();
    }

    @PutMapping("{name}")
    public ResponseEntity<Void> updateCompany(@RequestBody UpdateCompanyRequest request, @PathVariable("name") String name) {
        Optional<Company> company = service.find(name);
        if (company.isPresent()) {
            UpdateCompanyRequest.dtoToEntityUpdater().apply(company.get(), request);
            service.update(company.get());
            return ResponseEntity
                    .accepted()
                    .build();
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCompanies(){
        service.deleteAll();
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("name") String name){
        Optional<Company> c = service.find(name);
        if(c.isPresent()){
            service.delete(c.get());
            return ResponseEntity
                    .ok()
                    .build();
        }
        else{
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

}
