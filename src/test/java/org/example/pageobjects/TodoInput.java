package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class TodoInput {

    private static final By TODO_INPUT_SELECTOR = cssSelector(".new-todo");

    private WebDriver browser;

    public TodoInput (WebDriver browser) {
        this.browser = browser;
    }

    public void createNewTodo(String name) {
        var todoInput = browser.findElement(TODO_INPUT_SELECTOR);
        todoInput.sendKeys(name);
        todoInput.sendKeys(Keys.ENTER);
    }

}
