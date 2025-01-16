package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;

public class BaseTestSetup {

    UserSteps steps = new UserSteps();

    @AfterEach
    public void closeBrowser() {
        steps.userClosesTodoMVCApp();
    }
}
