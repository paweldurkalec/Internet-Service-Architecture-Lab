package Project.Company.Service;


import Project.Company.Entity.Company;
import Project.Company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository cr){this.repository = cr;}

    public Optional<Company> find(String name){return repository.findById(name);}

    @Transactional
    public void create(Company c){repository.save(c);}

    @Transactional
    public void delete(Company c){repository.delete(c);}

}
