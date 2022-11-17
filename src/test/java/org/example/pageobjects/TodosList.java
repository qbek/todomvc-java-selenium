package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TodosList extends PageObject {

    By todoList = By.cssSelector(".todo-list");
    By todo = By.cssSelector(".todo-list li");
    By completeToggle = By.cssSelector(".todo-list li .toggle");
    By deleteButton = By.cssSelector(".todo-list li .destroy");
    By todoItemCompleted = By.cssSelector(".todo-list li.completed");


    @Step
    public void completeTodo() {
        find(completeToggle).click();
    }

    @Step
    public void checkIfTodoDisplayed(String name) {
        find(todoList).shouldContainText(name);
    }

    @Step
    public void checkIfTodoNOTDisplayed(String name) {
        find(todoList).shouldNotContainText(name);
    }

    @Step
    public void checkIfTodoMarkedAsCompleted() {
        find(todoItemCompleted).shouldBePresent();
//        String taskClasses = find(todoItemSelector).getAttribute("class");
//        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    @Step
    public void deleteTask() {
        new Actions(getDriver())
                .moveToElement(find(todo))
                .click(find(deleteButton))
                .perform();
    }
}
