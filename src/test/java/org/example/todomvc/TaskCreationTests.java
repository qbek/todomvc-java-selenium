package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskCreationTests extends BaseTestSetup {

    @Test
    public void userCanCreateANewTask () {
        String todoName = "Moje zadanie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTask(todoName);
        steps.userChecksIfTaskCreated(todoName);
    }

}
