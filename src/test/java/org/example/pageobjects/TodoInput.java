package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TodoInput extends PageObject {

    private final By inputTodoSelector = By.cssSelector(".new-todo");

    @Step
    public void createNewTodo (String name) {
        find(inputTodoSelector).sendKeys(name);
        find(inputTodoSelector).sendKeys(Keys.RETURN);
    }

    @Step
    public void waitForReady () {
        find(inputTodoSelector).waitUntilVisible();
    }
}
