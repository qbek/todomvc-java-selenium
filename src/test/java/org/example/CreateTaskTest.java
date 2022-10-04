package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTaskTest {

    WebDriver browser = new FirefoxDriver();

    @BeforeEach
    public void setup() {
        userOpenTodoMVC();
    }

    @AfterEach
    public void cleanup() {
        browser.close();
    }



    @Test
    public void userCanCreateATodo() {
        var todoName = "To jest moje fajniejsze zadanie";
        userCreatesANewTodo(todoName);
        userChecksIfTodoWasCreated(todoName);
    }

    @Test
    public void userCanCompleteTodo() {
        var todoName = "To jest zadanie do zamknięcia";
        userCreatesANewTodo(todoName);
        userCompletesTodo();
        userChecksItTodoIsMarkedAsCompleted();
        userChecksIfCompletedTodoIsNotOnActiveFilter(todoName);
        userChecksIfCompletedTodoIsOnCompletedFilter(todoName);
    }

    private void userChecksIfCompletedTodoIsOnCompletedFilter(String name) {
        var completedFilter = browser.findElement(By.cssSelector("[href=\"#/completed\""));
        completedFilter.click();

        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo is not on the list", todos, Matchers.equalTo(name));
    }

    private void userChecksIfCompletedTodoIsNotOnActiveFilter(String name) {
        var activeFilter = browser.findElement(By.cssSelector("[href=\"#/active\""));
        activeFilter.click();

        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo is not on the list", todos, Matchers.emptyOrNullString());
    }

    private void userChecksItTodoIsMarkedAsCompleted() {
//        var todoElement = browser.findElement(By.cssSelector(".todo-list > li"));
//        var todoClasses = todoElement.getAttribute("class");
//        MatcherAssert.assertThat("Todo should be marked as completed", todoClasses, Matchers.equalTo("completed"));

        var todoElements = browser.findElements(By.cssSelector(".todo-list > .completed"));
        MatcherAssert.assertThat("Todo marked as completed is on the list", todoElements.size(), Matchers.equalTo(1));
    }

    private void userCompletesTodo() {
        var todoCompleteToggle = browser.findElement(By.cssSelector(".toggle"));
        todoCompleteToggle.click();
    }


    private void userChecksIfTodoWasCreated(String todoName) {
        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.equalTo(todoName));
    }

    private void userOpenTodoMVC() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }

    private void userCreatesANewTodo(String name) {
        var todoInput = browser.findElement(By.cssSelector(".new-todo"));
        todoInput.sendKeys(name);
        todoInput.sendKeys(Keys.RETURN);
    }
}
