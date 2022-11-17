package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class NewTodo extends PageObject {

    By todoInputSelector = By.cssSelector(".new-todo");

    public void createTask(String taskName) {
        WebElement newTodoInput = getDriver().findElement(todoInputSelector);
        newTodoInput.sendKeys(taskName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

}
