package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodosListPO extends PageObject {
    By todoListEl = By.cssSelector(".todo-list");
    By completeButtonEl = By.cssSelector(".toggle");
    By todoItemEl = By.cssSelector(".todo-list li");

    public void checkIfTaskExists(String name) {
        WebElement todoItem = getDriver().findElement(todoListEl);
        MatcherAssert.assertThat("Todo has correct name", todoItem.getText(), Matchers.equalTo(name));
    }

    public void completeTask() {
        WebElement completedButton = getDriver().findElement(completeButtonEl);
        completedButton.click();
    }

    public void checkIfTaskCompleted() {
        WebElement taskItem = getDriver().findElement(todoItemEl);
        String taskClasses = taskItem.getAttribute("class");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    public void checkIfTaskNotExists() {
        List<WebElement> todoList = getDriver().findElements(todoListEl);
        MatcherAssert.assertThat("Task should not be on the Active list", todoList, Matchers.hasSize(0));
    }
}
