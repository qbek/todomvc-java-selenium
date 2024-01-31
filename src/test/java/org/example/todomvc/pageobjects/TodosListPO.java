package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
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

    @Step
    public void checkIfTaskExists(String name) {
        find(todoListEl).shouldContainText(name);
    }

    public void completeTask() {
        find(completeButtonEl).click();
    }

    public void checkIfTaskCompleted() {
        String taskClasses = find(todoItemEl).getAttribute("class");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    public void checkIfTaskNotExists() {
        MatcherAssert.assertThat("Task should not be on the Active list", findAll(todoListEl), Matchers.hasSize(0));
    }
}
