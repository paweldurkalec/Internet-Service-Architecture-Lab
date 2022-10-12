package Project.Controller;


import Project.Worker.Entity.Company;
import Project.Worker.Entity.Worker;
import Project.Worker.Service.CompanyService;
import Project.Worker.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@Component
public class CommandLine implements CommandLineRunner {

    private WorkerService workerService;

    private CompanyService companyService;
    @Autowired
    public CommandLine(WorkerService ws, CompanyService cs) {
        this.workerService = ws;
        this.companyService = cs;
    }

    private void listCommands(){
        System.out.println("Command list:");
        System.out.println("list -> list all commands");
        System.out.println("workers -> list all workers");
        System.out.println("companies -> list all companies");

        System.out.println("add worker <name> <age> <company's name> -> creates a worker");
        System.out.println("add company <name> <value> <type> -> creates a company");
        System.out.println("delete <company/worker> <company/worker's name> -> deletes a company or worker");

        System.out.println("exit -> exits application");
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String line;
        listCommands();
        while(true){
            line = reader.readLine();
            String[] words = line.split(" ");
            if(words[0].equals("exit")){
                break;
            }
            else if(words[0].equals("list")){
                listCommands();
            }
            else if(words[0].equals("workers")){
                workerService.findAll().forEach(element -> System.out.println(element.toString()));
            }
            else if(words[0].equals("companies")){
                companyService.findAll().forEach(element -> System.out.println(element.toString()));
            }
            else if(words[0].equals("add")){
                if(words[1].equals("company")){
                    companyService.create(new Company(words[2],Integer.parseInt(words[3]),words[4]));
                }
                else if(words[1].equals("worker")){
                    workerService.create(new Worker(words[2],Integer.parseInt(words[3]),companyService.find(words[4]).get()));
                }
            }
            else if(words[0].equals("delete")){
                if(words[1].equals("company")){
                    if(companyService.find(words[2]).isPresent()) {
                        companyService.delete(companyService.find(words[2]).get());
                    }
                }
                else if(words[1].equals("worker")){
                    if(workerService.find(words[2]).isPresent()) {
                        workerService.delete(workerService.find(words[2]).get());
                    }
                }
            }
        }

    }

}

