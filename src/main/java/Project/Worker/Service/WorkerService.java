package Project.Worker.Service;

import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import Project.Worker.Repository.CompanyRepository;
import Project.Worker.Repository.WorkerRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class WorkerService {

    private WorkerRepository repository;

    @Autowired
    public WorkerService(WorkerRepository wr){this.repository = wr;}

    public Optional<Worker> find(String name){return repository.find(name);}

    public HashSet<Worker> findAll(){return repository.findAll();}

    public void create(Worker w){repository.create(w);}

    public void delete(Worker w){repository.delete(w);}

}
