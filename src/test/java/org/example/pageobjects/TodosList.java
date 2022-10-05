package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TodosList extends PageObject {

    private final By TODOS_LIST = By.cssSelector(".todo-list");
    private final By COMPLETE_TOGGLE = By.cssSelector(".toggle");
    private final By TODO_COMPLETED = By.cssSelector(".todo-list > .completed");

    @Step
    public void checkIfTodoIsDisplayed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    @Step
    public void completeTodo() {
        find(COMPLETE_TOGGLE).click();
    }

    @Step
    public void checkIfTodoMarkedAsCompleted() {
        find(TODO_COMPLETED).shouldBePresent();
    }

    @Step
    public void checkIfTodoIsNOTDisplayed(String name) {
        find(TODOS_LIST).shouldNotContainText(name);
    }
}
