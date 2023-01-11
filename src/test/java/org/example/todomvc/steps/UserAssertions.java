package org.example.todomvc.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;

import org.example.todomvc.pageobject.TodosList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAssertions {

    @Steps
    TodosList todosList;

    @Step
    public void userChecksIfTodoWasCreated(String expectedName) {
        todosList.checkIfTodoDisplayed(expectedName);
    }

    @Step
    public void userChecksIfTodoIsMarkedAsCompleted() {
        todosList.checkIfTodoCompleted();
    }
}
