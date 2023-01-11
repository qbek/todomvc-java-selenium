package org.example.todomvc;

import org.example.todomvc.steps.UserActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CompletionTodoTests extends BaseSetup {

    @Test
    public void userCanCompleteTodo() {
        String todoName = "Todo to be completed";
        step.userOpensTodoMVCApp();
        step.userCreatesANewTodo(todoName);
        step.userCompleteTodo();
        step.userChecksIfTodoIsMarkedAsCompleted();
    }
}
