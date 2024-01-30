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

public class TaskCreationTests {

    By newTodoInputEl = By.cssSelector(".new-todo");
    By todoListEl = By.cssSelector(".todo-list");

    WebDriver browser = new FirefoxDriver();


    @AfterEach
    public void cleanup() {
        browser.close();
    }

    @Test
    public void userCanCreateANewTask () {
        String todoName = "Moje zadanie";
        userOpensTodoMVCapp();
        userCreatesANewTask(todoName);
        userChecksIfTaskCreated(todoName);
    }

    @Test
    public void userCanCompleteTask () {
        
    }

    private void userChecksIfTaskCreated(String todoName) {
        //User checks if todo is created
        WebElement todoItem = browser.findElement(todoListEl);
        MatcherAssert.assertThat("Todo has correct name", todoItem.getText(), Matchers.equalTo(todoName));
    }

    private void userCreatesANewTask(String todoName) {
        WebElement newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    private void userOpensTodoMVCapp() {
        browser.get("https://todomvc.com/examples/angular/dist/browser/#/all");
    }

}
