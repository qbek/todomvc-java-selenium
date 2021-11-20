package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CreateTodoTest {

    WebDriver browser = new FirefoxDriver();

    @After
    public void finishTest() {
        browser.close();
    }

    @Test
    public void user_can_create_a_new_todo() throws InterruptedException {
        String todoName = "Nauczyć się automatyzacji testów";
        userOpensTodoMvcApplication();
        userCreatesANewTodo(todoName);
        userChecksIfTodoWasCreated(todoName);
    }

    private void userOpensTodoMvcApplication() throws InterruptedException {
        int sleepTime = 1000;
        String todoMVC_URL = "https://todomvc.com/examples/jquery/#/all";
        browser.get(todoMVC_URL);
        Thread.sleep(sleepTime);
    }

    private void userCreatesANewTodo(String name) {
        By inputTodo = By.cssSelector(".new-todo");
        WebElement newTodoInput = browser.findElement(inputTodo);
        newTodoInput.sendKeys(name);
        newTodoInput.sendKeys(Keys.RETURN);
    }

    private void userChecksIfTodoWasCreated(String expectedName) {
        By todoList = By.cssSelector(".todo-list li");
        WebElement todos = browser.findElement(todoList);
        String todoName = todos.getText();
        MatcherAssert.assertThat("Todo list shoudl contain created todo", todoName, Matchers.equalTo(expectedName));
    }
}
