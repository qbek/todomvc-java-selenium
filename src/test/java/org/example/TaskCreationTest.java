package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskCreationTest {

    By todoInputSelector = By.cssSelector(".new-todo");
    By todoListSelector = By.cssSelector(".todo-list");

    WebDriver browser = new FirefoxDriver();

    @BeforeEach
    public void setup() {
        userOpensTodoMVCApp();
    }

    @AfterEach
    public void cleanup() {
        browser.close();
    }

    @Test
    public void userCanCreateATask() {
        String taskName = "To jest zadanie";
        userCreatesNewTask(taskName);
        userChecksIfTodoIsOnTheList(taskName);
    }



    private void userChecksIfTodoIsOnTheList(String taskName) {
        WebElement todosList = browser.findElement(todoListSelector);
        String todos = todosList.getText();
        MatcherAssert.assertThat("Todo should be on the list", todos, Matchers.equalTo("test"));
    }

    private void userCreatesNewTask(String taskName) {
        WebElement newTodoInput = browser.findElement(todoInputSelector);
        newTodoInput.sendKeys(taskName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    private void userOpensTodoMVCApp() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }
}
