package org.example;

import com.sun.xml.bind.v2.TODO;
import jxl.common.AssertionFailed;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;

public class CreationTodoTests {

    private WebDriver browser = new FirefoxDriver();

    private static final By TODO_INPUT_SELECTOR = cssSelector(".new-todo");
    private static final By TODOS_LIST_SELECTOR = cssSelector(".todo-list");
    private static final By TODO_SELECTOR = cssSelector(".todo-list li");

    private static final By ACTIVE_FILTER_SELECTOR = cssSelector("[href=\"#/active\"]");
    private static final By COMPLETED_FILTER_SELECTOR = cssSelector("[href=\"#/completed\"]");

    @AfterEach
    public void closeTodoMVCapp() {
        browser.close();
    }

    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie";
        userOpensTodoMVCapp();
        userCreatesNewTodo(todoName);
        userChecksIfTodoWasCreated(todoName);
    }

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Complete me";
        userOpensTodoMVCapp();
        userCreatesNewTodo(todoName);
        userCompletesTodo();
        userChecksIfTodoMarkedAsCompleted();
        userChecksIfCompletedTodoNotOnActiveTab(todoName);
        userChecksIfCompletedTodoOnCompletedTab(todoName);
    }

    private void userChecksIfCompletedTodoOnCompletedTab(String todoName) {
        var completedFilter = browser.findElement(COMPLETED_FILTER_SELECTOR);
        completedFilter.click();
        var todos = browser.findElement(TODOS_LIST_SELECTOR);
        assertThat("Todo should be on the list", todos.getText(), equalTo(todoName));
    }

    private void userChecksIfCompletedTodoNotOnActiveTab(String todoName) {
        var activeFilter = browser.findElement(ACTIVE_FILTER_SELECTOR);
        activeFilter.click();
        var todos = browser.findElement(TODOS_LIST_SELECTOR);
        assertThat("Completed todo should not be on the list", todos.getText(), not(containsString(todoName)));
    }

    private void userChecksIfTodoMarkedAsCompleted() {
        var todo = browser.findElement(TODO_SELECTOR);
        assertThat("Todo is marked as completed", todo.getAttribute("class"), equalTo("completed"));
    }


    private void userCompletesTodo() {
        var todoToggle = browser.findElement(By.cssSelector(".toggle"));
        todoToggle.click();
    }

    private void userChecksIfTodoWasCreated(String todoName) {
        var todosList = browser.findElement(TODOS_LIST_SELECTOR);
        assertThat("Todo should be on the list", todosList.getText(), equalTo(todoName));
    }

    private void userCreatesNewTodo(String todoName) {
        var todoInput = browser.findElement(TODO_INPUT_SELECTOR);
        todoInput.sendKeys(todoName);
        todoInput.sendKeys(Keys.ENTER);
    }


    private void userOpensTodoMVCapp() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }


}
