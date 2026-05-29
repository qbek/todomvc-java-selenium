package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewTodoInputPO extends PageObject {
    private final static By NEW_TODO_INPUT_SELECTOR =  By.cssSelector("#new-todo");

    public void enterTodoName(String name) {
        var newTodoInput = getDriver().findElement(NEW_TODO_INPUT_SELECTOR);
        newTodoInput.sendKeys(name);
    }

    public void submitTodo() {
        var newTodoInput = getDriver().findElement(NEW_TODO_INPUT_SELECTOR);
        newTodoInput.sendKeys(Keys.ENTER);
    }
}
