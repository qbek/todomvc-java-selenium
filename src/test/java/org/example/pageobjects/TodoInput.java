package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TodoInput {
    private static final By NEW_TODO_INPUT_SELECTOR =  By.cssSelector("#new-todo");
    private WebDriver browser;

    public TodoInput(WebDriver browser) {
        this.browser = browser;
    }

    public void enterTodoName(String name) {
        var el = browser.findElement(NEW_TODO_INPUT_SELECTOR);
        el.sendKeys(name);
    }

    public void submitTodo() {
        var el = browser.findElement(NEW_TODO_INPUT_SELECTOR);
        el.sendKeys(Keys.RETURN);
    }

}