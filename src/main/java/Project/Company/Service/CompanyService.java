package Project.Company.Service;


import Project.Company.Entity.Company;
import Project.Company.Event.repository.CompanyEventRepository;
import Project.Company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository repository;

    private CompanyEventRepository eventRepository;

    @Autowired
    public CompanyService(CompanyRepository cr, CompanyEventRepository cer){
        this.repository = cr;
        this.eventRepository = cer;}

    public Optional<Company> find(String name){return repository.findById(name);}

    public List<Company> findAll(){return repository.findAll();}

    @Transactional
    public void create(Company c){
        repository.save(c);
        eventRepository.create(c);
    }

    @Transactional
    public void update(Company c){repository.save(c);}

    @Transactional
    public void delete(Company c){
        repository.delete(c);
        eventRepository.delete(c);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
