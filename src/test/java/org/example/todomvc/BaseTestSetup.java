package org.example.todomvc;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseTestSetup {

    @Steps(shared = true)
    protected UserSteps steps;

    @AfterEach
    public void cleanup() {
        steps.userClosesTodoMVCapp();
    }
}

