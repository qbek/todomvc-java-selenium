package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CreateTodoTest {


    @Test
    public void user_can_create_a_new_todo() {
        WebDriver browser = new FirefoxDriver();

        browser.get("https://todomvc.com/examples/jquery/#/all");

        WebElement input = browser.findElement(By.cssSelector(".new-todo"));
        input.sendKeys("Nauczyć się automatyzacji testów");
        input.sendKeys(Keys.RETURN);

        WebElement list = browser.findElement(By.cssSelector(".todo-list li"));
        String todo = list.getText();

        MatcherAssert.assertThat("Opis", todo, Matchers.equalTo("Nauczyć się automatyzacji testów"));

        browser.close();
    }
}
