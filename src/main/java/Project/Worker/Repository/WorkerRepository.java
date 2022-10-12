package Project.Worker.Repository;

import Project.DataStorage.DataStorage;
import Project.Repository.Repository;
import Project.Worker.Entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class WorkerRepository implements Repository<Worker, String> {
    private DataStorage data_storage;

    @Autowired
    public WorkerRepository(DataStorage s){
        this.data_storage = s;
    }

    @Override
    public Optional<Worker> find(String name) {
        return data_storage.workers.stream().filter(company -> company.name.equals(name)).findFirst();
    }

    @Override
    public HashSet<Worker> findAll() {
        return data_storage.workers;
    }

    @Override
    public void create(Worker w) {
        data_storage.workers.add(w);
    }

    @Override
    public void delete(Worker w) {data_storage.workers.remove(w);}
}
