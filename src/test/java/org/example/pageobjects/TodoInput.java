package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class TodoInput extends PageObject {
    private static final By NEW_TODO_INPUT_SELECTOR =  By.cssSelector("#new-todo");

    public void enterTodoName(String name) {
        find(NEW_TODO_INPUT_SELECTOR).type(name);
    }

    public void submitTodo() {
        find(NEW_TODO_INPUT_SELECTOR).sendKeys(Keys.RETURN);
    }

}