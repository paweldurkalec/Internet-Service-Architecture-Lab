package Project.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    public CommandLine() {

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("working");
    }

}

