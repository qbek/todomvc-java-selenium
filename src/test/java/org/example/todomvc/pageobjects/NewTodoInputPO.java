package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.example.todomvc.BaseTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTodoInputPO extends PageObject {

    By newTodoInputEl = By.cssSelector(".new-todo");

    @Step
    public void enterTaskName (String name) {
        find(newTodoInputEl).type(name);
    }

    @Step
    public void submitTask() {
        find(newTodoInputEl).type(Keys.RETURN);
    }
}
