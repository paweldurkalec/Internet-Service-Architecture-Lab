package Project.Worker.Service;

import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import Project.Worker.Repository.CompanyRepository;
import Project.Worker.Repository.WorkerRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private WorkerRepository repository;

    @Autowired
    public WorkerService(WorkerRepository wr){this.repository = wr;}

    public Optional<Worker> find(String name){return repository.findById(name);}

    public List<Worker> findAll(){return repository.findAll();}

    @Transactional
    public void create(Worker w){repository.save(w);}

    public void update(Worker w){repository.save(w);}

    @Transactional
    public void delete(Worker w){repository.delete(w);}

    public void deleteAll(){repository.deleteAll();}

}
