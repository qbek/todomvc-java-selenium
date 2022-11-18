package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class NewTodo extends PageObject {

    private By todoInput = By.cssSelector(".new-todo");

    @Step("Enters task name '{0}' into: #todoInput")
    public void createTask(String taskName) {
        find(todoInput).typeAndEnter(taskName);
    }

}
