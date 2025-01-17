package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class NewTodoInput extends PageObject {

    By newTodoInputEl = By.cssSelector("#new-todo");

    @Step
    public void enterTodoName(String name) {
        find(newTodoInputEl).type(name);
    }

    @Step
    public void submitTodo() {
        find(newTodoInputEl).sendKeys(Keys.ENTER);
    }

}
