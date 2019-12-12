package com.github.qbek.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoInput extends PageObject {

    By newTodoInput = By.cssSelector(".new-todo");

    public void enterText(String text) {
        WebDriver browser = getDriver();
        WebElement todoInput = browser.findElement(newTodoInput);
        todoInput.sendKeys(text);
    }

    public void pressEnter() {
        WebDriver browser = getDriver();
        WebElement todoInput = browser.findElement(newTodoInput);
        todoInput.sendKeys(Keys.ENTER);
    }

}
