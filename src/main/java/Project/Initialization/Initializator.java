package Project.Initialization;

import Project.Company.Entity.Company;
import Project.Company.Repository.CompanyRepository;
import Project.Company.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializator {
    private CompanyRepository companyRepository;

    @Autowired
    public Initializator(CompanyRepository cs){
        this.companyRepository = cs;
    }

    @PostConstruct
    private void init() {
        Company c1 = Company.builder()
                .name("Ontel")
                .value(1000)
                .type("IT")
                .build();

        Company c2 = Company.builder()
                .name("Frog")
                .value(100)
                .type("FoodTrading")
                .build();

        companyRepository.save(c1);
        companyRepository.save(c2);
    }

}
