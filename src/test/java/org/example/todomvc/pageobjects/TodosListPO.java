package org.example.todomvc.pageobjects;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodosListPO {
    private final static By TODO_LIST = By.cssSelector("#todo-list");
    private final static By TODO_ELEMENT = By.cssSelector("#todo-list li");
    private final static By TODO_COMPLETE_TOGGGLE = By.cssSelector(".toggle");

    private WebDriver browser;

    public TodosListPO (WebDriver browser) {
        this.browser = browser;
    }

    public void completeTodo() {
        var todoCompleteToggle = browser.findElement(TODO_COMPLETE_TOGGGLE);
        todoCompleteToggle.click();
    }

    public void checkTodoIsOnTheList(String name) {
        var todoLabel = browser.findElement(TODO_LIST);
        MatcherAssert.assertThat("Created todo has valid name",
                todoLabel.getText(),
                Matchers.equalTo(name));
    }

    public void checkTodoListIsEmpty() {
        var todosList = browser.findElement(TODO_LIST);
        MatcherAssert.assertThat("Todos list is empty",
                todosList.getText(),
                Matchers.emptyString());
    }

    public void checkTodoMarkedAsCompleted() {
        var todoElement = browser.findElement(TODO_ELEMENT);
        MatcherAssert.assertThat("Todo is marked as completed",
                todoElement.getAttribute("class"),
                Matchers.containsString("completed")
        );
    }
}
