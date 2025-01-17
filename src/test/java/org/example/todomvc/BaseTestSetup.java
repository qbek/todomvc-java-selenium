package org.example.todomvc;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.todomvc.steps.UserActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseTestSetup {

    @Steps(shared = true)
    UserActions userActions;

    @AfterEach
    public void closeBrowser() {
        userActions.userClosesTodoMVCApp();
    }
}
