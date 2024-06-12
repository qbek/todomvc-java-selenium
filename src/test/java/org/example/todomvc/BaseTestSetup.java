package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;

public class BaseTestSetup {

    protected UserSteps steps = new UserSteps();

    @AfterEach
    public void cleanup() {
        steps.userClosesTodoMVCapp();
    }
}
