package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TodoInput extends PageObject {

    private final By TODO_INPUT = By.cssSelector(".new-todo");

    @Step
    public void addTodo(String name) {
        find(TODO_INPUT).typeAndEnter(name);
    }
}
