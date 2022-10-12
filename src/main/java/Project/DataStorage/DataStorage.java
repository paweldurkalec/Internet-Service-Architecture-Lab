package Project.DataStorage;

import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataStorage {
    public HashSet<Worker> workers = new HashSet<>();
    public HashSet<Company> companies = new HashSet<>();
}
