package Project.Worker.Controller;

//import Project.Worker.DTO.GetWorkersResponse;
import Project.Worker.DTO.CreateWorkerRequest;
import Project.Worker.DTO.GetWorkersResponse;
import Project.Worker.DTO.GetWorkerResponse;
import Project.Worker.DTO.UpdateWorkerRequest;
import Project.Worker.Entity.Worker;
import Project.Company.Service.CompanyService;
import Project.Worker.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/workers")
public class WorkerController {

    private WorkerService service;

    private CompanyService companyService ;

    @Autowired
    public WorkerController(WorkerService service, CompanyService  companyService ){
        this.service = service;
        this.companyService  = companyService ;
    }

    @GetMapping("{name}")
    public ResponseEntity<GetWorkerResponse> getWorker(@PathVariable("name") String name) {
        return service.find(name)
                .map(value -> ResponseEntity
                        .ok(GetWorkerResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @GetMapping
    public ResponseEntity<GetWorkersResponse> getWorkers() {
        return ResponseEntity
                .ok(GetWorkersResponse.entityToDtoMapper().apply(service.findAll()));
    }

    @PostMapping
    public ResponseEntity<Void> createWorker(@RequestBody CreateWorkerRequest request, UriComponentsBuilder builder) {
        Worker worker = CreateWorkerRequest
                .dtoToEntityMapper()
                .apply(request);
        //company must exists!!!!
        worker.setCompany(companyService.find(request.getCompany()).get());
        service.create(worker);
        return ResponseEntity
                .created(builder
                        .pathSegment("api", "workers", "{name}")
                        .buildAndExpand(worker.getName()).toUri())
                .build();
    }

    @PutMapping("{name}")
    public ResponseEntity<Void> updateWorker(@RequestBody UpdateWorkerRequest request, @PathVariable("name") String name) {
        Optional<Worker> worker = service.find(name);
        if (worker.isPresent()) {
            UpdateWorkerRequest.dtoToEntityUpdater().apply(worker.get(), request);
            worker.get().setCompany(companyService.find(request.getCompany()).get());
            service.update(worker.get());
            return ResponseEntity
                    .accepted()
                    .build();
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkers(){
        service.deleteAll();
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("name") String name){
        Optional<Worker> w = service.find(name);
        if(w.isPresent()){
            service.delete(w.get());
            return ResponseEntity
                    .ok()
                    .build();
        }
        else{
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

}
