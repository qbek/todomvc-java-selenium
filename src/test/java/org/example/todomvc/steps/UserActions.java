package org.example.todomvc.steps;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserActions {
    private final String TODOMVC_URL = "https://todomvc.com/examples/jquery/#/all";
    private final By NEW_TODO_INPUT = By.cssSelector(".new-todo");
    private final By TODO_ELEMENT = By.cssSelector(".todo-list li");
    private WebDriver browser;

    public UserActions (WebDriver browser) {
        this.browser = browser;
    }

    public void userOpensTodoMVCApp() {
        browser.get(TODOMVC_URL);
    }

    public void userCreatesANewTodo(String name) {
        WebElement todoInput = browser.findElement(NEW_TODO_INPUT);
        todoInput.sendKeys(name);
        todoInput.sendKeys(Keys.ENTER);
    }

    public void userChecksIfTodoWasCreated(String expectedName) {
        WebElement todo = browser.findElement(TODO_ELEMENT);
        String todoText = todo.getText();
        Assertions.assertThat(todoText).isEqualTo(expectedName);
    }

    public void userCompleteTodo() {
        WebElement toggle = browser.findElement(By.cssSelector(".toggle"));
        toggle.click();
    }

    public void userChecksIfTodoIsMarkedAsCompleted() {
        WebElement todo = browser.findElement(TODO_ELEMENT);
        String classes = todo.getAttribute("class");
        Assertions.assertThat(classes).as("Completed todo should have class completed").isEqualTo("completed");
    }
}
