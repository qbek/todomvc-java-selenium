package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TodosList extends PageObject {

    By todoListSelector = By.cssSelector(".todo-list");
    By todoItemSelector = By.cssSelector(".todo-list li");
    By completeButtonSelector = By.cssSelector(".todo-list li .toggle");


    @Step
    public void completeTodo() {
        WebElement completedButton = getDriver().findElement(completeButtonSelector);
        completedButton.click();
    }

    @Step
    public void checkIfTodoDisplayed(String name) {
        WebElement todosList = getDriver().findElement(todoListSelector);
        MatcherAssert.assertThat("Todo should be on the list", todosList.getText(), Matchers.equalTo(name));
    }

    @Step
    public void checkIfTodoNOTDisplayed(String name) {
        WebElement todoList = getDriver().findElement(todoListSelector);
        MatcherAssert.assertThat("Task should not be on the Active list", todoList.getText(), Matchers.containsString(name));
    }

    @Step
    public void checkIfTodoMarkedAsCompleted() {
        WebElement taskItem = getDriver().findElement(todoItemSelector);
        String taskClasses = taskItem.getAttribute("class");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }
}
