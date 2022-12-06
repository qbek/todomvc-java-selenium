package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class TodoInput extends PageObject {

    private static final By TODO_INPUT = cssSelector(".new-todo");

    @Step
    public void createNewTodo(String name) {
        find(TODO_INPUT).typeAndEnter(name);
    }

}
