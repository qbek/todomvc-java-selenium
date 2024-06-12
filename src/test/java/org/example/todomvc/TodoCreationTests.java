package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.*;

public class TodoCreationTests {

    private By newTodoInputEl = cssSelector(".new-todo");
    private By todoListEl = cssSelector(".todo-list");

    private String todoMvcURL = "https://todomvc.com/examples/angular/dist/browser/#/all";

    private WebDriver browser = new FirefoxDriver();

    @AfterEach
    public void cleanup() {
        userClosesTodoMVCapp();
    }

    @Test
    public void userCanCreateATodo() {
        var todoName = "Moje lepsze zadanie 2";

        userOpensTodoMVCapp();
        userCreatesANewTodo(todoName);
        userChecksIfTodoIsCreated(todoName);
    }

    private void userOpensTodoMVCapp() {
        browser.get(todoMvcURL);
    }

    private void userClosesTodoMVCapp() {
        browser.close();
    }

    private void userCreatesANewTodo(String name) {
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(name);
        newTodoInput.sendKeys(ENTER);
    }

    private void userChecksIfTodoIsCreated(String expectedName) {
        var todoItem = browser.findElement(todoListEl);
        assertThat("Todo has correct name", todoItem.getText(), equalTo(expectedName));
    }
}
