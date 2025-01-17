package org.example.todomvc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewTodoInput {
    WebDriver browser;
    By newTodoInputEl = By.cssSelector("#new-todo");

    public NewTodoInput(WebDriver browser) {
        this.browser = browser;
    }

    public void enterTodoName(String name) {
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(name);
    }

    public void submitTodo() {
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(Keys.ENTER);
    }
}
