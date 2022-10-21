package Project.Worker.Controller;

import Project.Worker.Entity.Company;
import Project.Worker.Repository.CompanyRepository;
import Project.Worker.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Optional;

@Controller
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service){ this.service = service;}

    public Optional<Company> find(String name){return service.find(name);}

    public HashSet<Company> findAll(){return service.findAll();}

    public void create(Company c){service.create(c);}

    public void delete(Company c){service.delete(c);}
}
