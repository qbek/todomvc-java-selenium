package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTaskTest {

    @Test
    public void userCanCreateATodo() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("https://todomvc.com/examples/jquery/#/all");
        ////By.xpath("//*contains([@class, 'new-todo']"));
        var todoInput = browser.findElement(By.cssSelector(".new-todo"));
        todoInput.sendKeys("To jest moje zadanie");
        todoInput.sendKeys(Keys.RETURN);

        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();

        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.equalTo("To jest moje zadanie"));

        Thread.sleep(2000);
        browser.close();
    }
}
