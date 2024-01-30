package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.example.todomvc.BaseTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTodoInputPO extends PageObject {

    By newTodoInputEl = By.cssSelector(".new-todo");


    public void enterTaskName (String name) {
        WebElement newTodoInput = getDriver().findElement(newTodoInputEl);
        newTodoInput.sendKeys(name);
    }

    public void submitTask() {
        WebElement newTodoInput = getDriver().findElement(newTodoInputEl);
        newTodoInput.sendKeys(Keys.ENTER);
    }
}
