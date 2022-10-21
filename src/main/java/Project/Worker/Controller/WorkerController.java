package Project.Worker.Controller;

import Project.Worker.Entity.Worker;
import Project.Worker.Repository.WorkerRepository;
import Project.Worker.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Optional;

@Controller
public class WorkerController {
    private final WorkerService service;

    @Autowired
    public WorkerController(WorkerService service){this.service = service;}

    public Optional<Worker> find(String name){return service.find(name);}

    public HashSet<Worker> findAll(){return service.findAll();}

    public void create(Worker w){service.create(w);}

    public void delete(Worker w){service.delete(w);}
}
