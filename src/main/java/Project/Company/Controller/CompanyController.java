package Project.Company.Controller;

//import Project.Worker.DTO.GetCompaniesResponse;
import Project.Company.DTO.CreateCompanyRequest;
import Project.Company.Entity.Company;
import Project.Company.Service.CompanyService;
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

    @DeleteMapping("{companyname}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("companyname") String name){
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
