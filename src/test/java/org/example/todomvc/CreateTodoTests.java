package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests {

    String todoName = "Moje super zadanie";
    String todoMVCUrl = "https://todomvc.com/examples/jquery/dist/#/all";

    By newTodoInputEl = By.cssSelector("#new-todo");
    By todosListEl = By.cssSelector("#todo-list");
        
    @Test
    public void userCanCreateATodo() {
        WebDriver browser = new FirefoxDriver();
        browser.get(todoMVCUrl);

        WebElement newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);

        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(todoName));

        browser.close();
    }
}
