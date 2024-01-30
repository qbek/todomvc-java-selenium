package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskCreationTests {

    @Test
    public void userCanCreateANewTask () {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://todomvc.com/examples/angular/dist/browser/#/all");

        WebElement newTodoInput = browser.findElement(By.cssSelector(".new-todo"));
        newTodoInput.sendKeys("Moje zadanie");
        newTodoInput.sendKeys(Keys.ENTER);

        WebElement todoItem = browser.findElement(By.cssSelector(".todo-list label"));
        MatcherAssert.assertThat("Todo has correct name", todoItem.getText(), Matchers.equalTo("Moje zadanie"));


        browser.close();
    }


}
