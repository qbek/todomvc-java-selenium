package org.example.todomvc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewTodoInputPO {
    private final static By NEW_TODO_INPUT_SELECTOR =  By.cssSelector("#new-todo");
    private WebDriver browser;

    public NewTodoInputPO(WebDriver browser) {
        this.browser = browser;
    }

    public void enterTodoName(String name) {
        var newTodoInput = browser.findElement(NEW_TODO_INPUT_SELECTOR);
        newTodoInput.sendKeys(name);
    }

    public void submitTodo() {
        var newTodoInput = browser.findElement(NEW_TODO_INPUT_SELECTOR);
        newTodoInput.sendKeys(Keys.ENTER);
    }
}
