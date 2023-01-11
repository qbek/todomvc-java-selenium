package org.example.todomvc;

import org.assertj.core.api.Assertions;
import org.example.todomvc.steps.UserActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatingTodosTests extends BaseSetup {

    @Test
    public void userCanCreateNewTodo() {
        String todoName = "To moje lepsze zadanie";
        step.userOpensTodoMVCApp();
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoWasCreated(todoName);
    }

}
