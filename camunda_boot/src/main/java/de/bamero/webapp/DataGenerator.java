package de.bamero.webapp;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DataGenerator {

    private final static Logger LOGGER = Logger.getLogger(DataGenerator.class.getName());

    private ProcessEngine engine;

    public DataGenerator(ProcessEngine engine) {
        this.engine = engine;
    }

    public void createUserandGroup() {

        IdentityService identityService = engine.getIdentityService();
        if(identityService.isReadOnly()) {
            LOGGER.info("Identity service provider is Read Only, can't create user");
        }
        else {
            LOGGER.info("Identity service provider is not Read Only can procede");
        }

        User user = identityService.newUser("jim");
        user.setFirstName("jim");
        user.setLastName("harper");
        user.setPassword("jim");
        user.setEmail("jim@dundermifflin.com");
        identityService.saveUser(user);

        Group salesGroup = identityService.newGroup("sales");
        salesGroup.setName("Sales");
        salesGroup.setType("WORKFLOW");
        identityService.saveGroup(salesGroup);

        identityService.createMembership("jim", "sales");

    }
}
