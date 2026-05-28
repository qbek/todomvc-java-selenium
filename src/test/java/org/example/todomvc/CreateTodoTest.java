package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTest {

    @Test
    public void userCanCreateATodo() {
        var browser = new FirefoxDriver();
        browser.get("https://todomvc.com/examples/jquery/dist/#/all");

        var newTodoInput = browser.findElement(By.cssSelector("#new-todo"));
        newTodoInput.sendKeys("Moje pierwsze Todo");
        newTodoInput.sendKeys(Keys.ENTER);

        var todoLabel = browser.findElement(By.cssSelector("#todo-list label"));
        MatcherAssert.assertThat("Created todo has valid name",
                todoLabel.getText(),
                Matchers.equalTo("Moje pierwsze Todo"));

        browser.close();
    }
}
