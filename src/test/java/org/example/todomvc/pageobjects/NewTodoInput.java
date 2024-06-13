package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.ENTER;

public class NewTodoInput extends PageObject {
    private By newTodoInputEl = cssSelector(".new-todo");


    @Step
    public void enterTodoName(String name) {
        find(newTodoInputEl).type(name);
    }

    @Step
    public void submitTodo() {
        find(newTodoInputEl).type(ENTER);
    }
}
