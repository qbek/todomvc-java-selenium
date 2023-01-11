package org.example.todomvc.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoInput extends PageObject {

    private final By NEW_TODO_INPUT = By.cssSelector(".new-todo");

    @Step("Type todo name: {0} into: #NEW_TODO_INPUT and press ENTER")
    public void createTodo(String name) {
        find(NEW_TODO_INPUT).typeAndEnter(name);
    }

}
