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

public class CreateTaskTests {

    private static final By NEW_TODO_INPUT = By.cssSelector(".new-todo");
    private static final By TODOS_LIST = By.cssSelector(".todo-list");
    private static final By TODO_COMPLETE_BUTTON = By.cssSelector(".todo-list .toggle");
    private static final By COMPLETED_TODO = By.cssSelector(".todo-list .completed");
    private static final String TODOMVC_URL = "https://todomvc.com/examples/jquery/#/all";

    private WebDriver browser = new FirefoxDriver();

    @BeforeEach
    public void setup() {
        userOpensTodoMVCApp();
    }

    @AfterEach
    public void cleanUp() {
        userClosesTodoMVCApp();
    }

    @Test
    public void userCanAddTodo() {
        var todoName = "To jest moje lepsze zadanie";
        userAddsANewTodo(todoName);
        userChecksIfTodoIsCreated(todoName);
    }

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = "Ten task jest zakończony";
        userAddsANewTodo(todoName);
        userCompletesTodo();
        userChecksIfTodoIsMarkedAsCompleted();
        userChecksIfCompletedTaskIsNotOnActiveTab(todoName);
        userChecksIfCompletedTaskIsNotOnCompletedTab(todoName);
    }

    private void userChecksIfCompletedTaskIsNotOnCompletedTab(String todoName) {
        var completedFilter = browser.findElement(By.cssSelector(".filters [href='#/completed']"));
        completedFilter.click();
        var allTodos = browser.findElement(TODOS_LIST);
        var todos = allTodos.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.containsString(todoName));
    }

    private void userChecksIfCompletedTaskIsNotOnActiveTab(String todoName) {
        var activeFilter = browser.findElement(By.cssSelector(".filters [href='#/active']"));
        activeFilter.click();
        var allTodos = browser.findElement(TODOS_LIST);
        var todos = allTodos.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.not(Matchers.containsString(todoName)));

    }

    private void userChecksIfTodoIsMarkedAsCompleted() {
        //pierwszy sposób poprzez sprawdzanie czy została dodana klasa "comnpleted"
//        var todo = browser.findElement(By.cssSelector(".todo-list li"));
//        var classes = todo.getAttribute("class");
//        MatcherAssert.assertThat("Todo is marked as completed", classes, Matchers.equalTo("completed"));

        //drugi sposób -> sprawdzamy czy istnieje zakonzone todo
        var completedTodos = browser.findElements(COMPLETED_TODO);
        MatcherAssert.assertThat("There is a todo marked as completed", completedTodos, Matchers.hasSize(1));
    }

    private void userCompletesTodo() {
        var completeToggle = browser.findElement(TODO_COMPLETE_BUTTON);
        completeToggle.click();
    }

    private void userChecksIfTodoIsCreated(String todoName) {
        var allTodos = browser.findElement(TODOS_LIST);
        var todos = allTodos.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.containsString(todoName));
    }

    private void userAddsANewTodo(String todoName) {
        var newTodoInput = browser.findElement(NEW_TODO_INPUT); //By.xpath("//*[contains(@class, 'new-todo')]"));
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.RETURN);
    }



    private void userOpensTodoMVCApp() {
        browser.get(TODOMVC_URL);
    }

    private void userClosesTodoMVCApp() {
        browser.close();
    }

}
