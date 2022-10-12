package Project.Initialization;

import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import Project.Worker.Service.CompanyService;
import Project.Worker.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializator {
    private WorkerService workerService;
    private CompanyService companyService;

    @Autowired
    public Initializator(CompanyService cs, WorkerService ws){
        this.workerService = ws;
        this.companyService = cs;
    }

    @PostConstruct
    private void init() {
        Company c1 = Company.builder()
                .name("Ontel")
                .value(1000)
                .type("IT")
                .build();

        Company c2 = Company.builder()
                .name("Frog")
                .value(100)
                .type("FoodTrading")
                .build();

        Worker w1 = Worker.builder()
                .name("Marek")
                .age(19)
                .company(c1)
                .build();

        Worker w2 = Worker.builder()
                .name("Krzysztof")
                .age(22)
                .company(c1)
                .build();

        Worker w3 = Worker.builder()
                .name("Roman")
                .age(30)
                .company(c2)
                .build();

        Worker w4 = Worker.builder()
                .name("Jan")
                .age(72)
                .company(c2)
                .build();

        companyService.create(c1);
        companyService.create(c2);
        workerService.create(w1);
        workerService.create(w2);
        workerService.create(w3);
        workerService.create(w4);
    }

}
