package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.ENTER;

public class NewTodoInput extends PageObject {
    private By newTodoInputEl = cssSelector(".new-todo");


    public void enterTodoName(String name) {
        var newTodoInput = getDriver().findElement(newTodoInputEl);
        newTodoInput.sendKeys(name);
    }

    public void submitTodo() {
        var newTodoInput = getDriver().findElement(newTodoInputEl);
        newTodoInput.sendKeys(ENTER);
    }
}
