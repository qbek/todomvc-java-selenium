package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests {

    String todoName = "Moje super zadanie";
    String todoMVCUrl = "https://todomvc.com/examples/jquery/dist/#/all";

    By newTodoInputEl = By.cssSelector("#new-todo");
    By todosListEl = By.cssSelector("#todo-list");

    WebDriver browser = new FirefoxDriver();

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

    @Test
    public void userCanCreateATodo() {
        userOpensTodoMVCapp();
        userCreatesANewTodo();
        userChecksIfTodoIsCreated();
    }

    private void userOpensTodoMVCapp() {
        browser.get(todoMVCUrl);
    }

    private void userCreatesANewTodo() {
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    private void userChecksIfTodoIsCreated() {
        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(todoName));
    }
}
