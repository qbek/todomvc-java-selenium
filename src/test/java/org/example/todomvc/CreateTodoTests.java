package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var name = "To jest moje zadanie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(name);
        steps.userChecksIfTodoIsCreated();
    }

}
