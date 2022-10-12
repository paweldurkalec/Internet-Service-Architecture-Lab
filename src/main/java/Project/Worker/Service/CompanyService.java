package Project.Worker.Service;


import Project.Worker.Entity.Company;
import Project.Worker.Repository.CompanyRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository cr){this.repository = cr;}

    public Optional<Company> find(String name){return repository.find(name);}

    public HashSet<Company> findAll(){return repository.findAll();}

    public void create(Company c){repository.create(c);}

    public void delete(Company c){repository.delete(c);}

}
