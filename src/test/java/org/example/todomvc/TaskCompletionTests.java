package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TaskCompletionTests extends BaseTestSetup {

    @Test
    public void userCanCompleteTask () {
        String todoName = "Moje zadanie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTask(todoName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsMarkedAsCompleted();
        steps.userChecksIfTaskInNOTOnActiveTab(todoName);
        steps.userChecksIfTaskIsOnCompletedTab(todoName);
    }
}
