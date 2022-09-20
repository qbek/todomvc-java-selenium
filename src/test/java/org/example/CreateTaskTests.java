package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;

public class CreateTaskTests {

    private static final By NEW_TODO_INPUT = By.cssSelector(".new-todo");
    private static final By TODOS_LIST = By.cssSelector(".todo-list");
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
        userAddANewTodo(todoName);
        userChecksIfTodoIsCreated(todoName);
    }

    private void userChecksIfTodoIsCreated(String todoName) {
        var allTodos = browser.findElement(TODOS_LIST);
        var todos = allTodos.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.containsString(todoName));
    }

    private void userAddANewTodo(String todoName) {
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
