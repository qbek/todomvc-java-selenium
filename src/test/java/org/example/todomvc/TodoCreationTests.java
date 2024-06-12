package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.*;

public class TodoCreationTests {

    @Test
    public void userCanCreateATodo() {
        var browser = new FirefoxDriver();
        browser.get("https://todomvc.com/examples/angular/dist/browser/#/all");

        var newTodoInput = browser.findElement(cssSelector(".new-todo"));
        newTodoInput.sendKeys("Moje zadanie");
        newTodoInput.sendKeys(ENTER);

        var todoItem = browser.findElement(cssSelector(".todo-list"));
        assertThat("Todo has correct name", todoItem.getText(), equalTo("Moje zadanie"));

        browser.close();
    }
}
