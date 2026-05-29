package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class NewTodoInputPO extends PageObject {
    private final static By NEW_TODO_INPUT_SELECTOR =  By.cssSelector("#new-todo");

    @Step
    public void enterTodoName(String name) {
        find(NEW_TODO_INPUT_SELECTOR).type(name);
    }

    @Step
    public void submitTodo() {
        find(NEW_TODO_INPUT_SELECTOR).sendKeys(Keys.ENTER);
    }
}
