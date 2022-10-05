package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TodosList extends PageObject {

    private final By TODOS_LIST = By.cssSelector(".todo-list");
    private final By COMPLETE_TOGGLE = By.cssSelector(".toggle");
    private final By TODO_COMPLETED = By.cssSelector(".todo-list > .completed");

    public void checkIfTodoIsDisplayed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    public void completeTodo() {
        find(COMPLETE_TOGGLE).click();
    }

    public void checkIfTodoMarkedAsCompleted() {
        find(TODO_COMPLETED).shouldBePresent();
    }
}
