package Project.Company.Event.repository;

import Project.Company.Entity.Company;
import Project.Company.Event.dto.PostCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CompanyEventRepository  {

    private RestTemplate restTemplate;

    @Autowired
    public CompanyEventRepository(@Value("${lab.workers.url}") String baseUrl) {
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(Company company) {
        restTemplate.delete("/companies/{name}", company.getName());
    }

    public void create(Company company) {
        restTemplate.postForLocation("/companies", PostCompanyRequest.entityToDtoMapper().apply(company));
    }
}
