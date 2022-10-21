package Project.Initialization;

import Project.Worker.Controller.CompanyController;
import Project.Worker.Controller.WorkerController;
import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import Project.Worker.Service.CompanyService;
import Project.Worker.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializator {
    private final WorkerController workerController;
    private final CompanyController companyController;

    @Autowired
    public Initializator(CompanyController cc, WorkerController wc){
        this.workerController = wc;
        this.companyController = cc;
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

        companyController.create(c1);
        companyController.create(c2);
        workerController.create(w1);
        workerController.create(w2);
        workerController.create(w3);
        workerController.create(w4);
    }

}
