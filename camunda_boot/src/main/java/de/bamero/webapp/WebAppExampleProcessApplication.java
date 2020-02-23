package de.bamero.webapp;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.h2.store.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebAppExampleProcessApplication implements CommandLineRunner {

    @Autowired
    private DataGenerator dataGenerator;

    @Autowired
    private ProcessEngine engine;

    public void run(String... args) throws Exception {
        //DataGenerator dataGenerator = new DataGenerator(engine);
        //dataGenerator.createUserandGroup();
    }

    public static void main(String... args) {
        SpringApplication.run(WebAppExampleProcessApplication.class, args);

    }


}
