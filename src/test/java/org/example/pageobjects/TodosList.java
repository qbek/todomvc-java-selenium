package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;

public class TodosList {

    private static final By TODOS_LIST_SELECTOR = cssSelector(".todo-list");
    private static final By TODO_SELECTOR = cssSelector(".todo-list li");
    private static final By TODO_COMPLETE_TOGGLE = cssSelector(".toggle");

    private final WebDriver browser;

    public TodosList(WebDriver browser) {
        this.browser = browser;
    }

    public void checkIfTodoDisplayed (String name) {
        var todos = browser.findElement(TODOS_LIST_SELECTOR);
        assertThat("Todo should be on the list", todos.getText(), equalTo(name));
    }

    public void checkIfTodoNOTDisplayed (String name) {
        var todos = browser.findElement(TODOS_LIST_SELECTOR);
        assertThat("Completed todo should not be on the list", todos.getText(), not(containsString(name)));
    }

    public void checkIfTodoCompleted () {
        var todo = browser.findElement(TODO_SELECTOR);
        assertThat("Todo is marked as completed", todo.getAttribute("class"), equalTo("completed"));
    }

    public void completeTodo() {
        var todoToggle = browser.findElement(TODO_COMPLETE_TOGGLE);
        todoToggle.click();
    }
}
