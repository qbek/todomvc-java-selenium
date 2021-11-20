package org.example.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class UserActions {

    private WebDriver browser = Serenity.getDriver();


    @Step
    public void userOpensTodoMvcApplication() throws InterruptedException {
        int sleepTime = 1000;
        String todoMVC_URL = "https://todomvc.com/examples/jquery/#/all";
        browser.get(todoMVC_URL);
        Thread.sleep(sleepTime);
    }

    @Step
    public void userCreatesANewTodo(String name) {
        By inputTodo = By.cssSelector(".new-todo");
        WebElement newTodoInput = browser.findElement(inputTodo);
        newTodoInput.sendKeys(name);
        newTodoInput.sendKeys(Keys.RETURN);
    }

    @Step
    public void userChecksIfTodoWasCreated(String expectedName) {
        By todoList = By.cssSelector(".todo-list li");
        WebElement todos = browser.findElement(todoList);
        String todoName = todos.getText();
        assertThat("Todo list shoudl contain created todo", todoName, equalTo(expectedName));
    }

    @Step
    public void userCompletesTheTodo() {
        By completeToggle = By.cssSelector(".todo-list li .toggle");
        WebElement toComplete = browser.findElement(completeToggle);
        toComplete.click();
    }

    @Step
    public void userChecksIfTodoIsMarkedAsCompleted() {
        String completitionMark = "completed";
        By todoElement = By.cssSelector(".todo-list li");
        WebElement todo = browser.findElement(todoElement);
        String todoClasses = todo.getAttribute("class");
        assertThat("Todo should be marked as completed", todoClasses, equalTo(completitionMark));
    }

    @Step
    public void userChecksIfCompletedTodoIsNOTonActiveList(String completedName) {
        By activeFilterElement = By.cssSelector(".filters [href=\"#/active\"]");
        By todoListElement = By.cssSelector(".todo-list");
        browser.findElement(activeFilterElement).click();
        WebElement todos = browser.findElement(todoListElement);
        assertThat("Completed todo is not on active list", todos.getText(), not(containsString(completedName)));
    }

    @Step
    public void userChecksIfCompletedTodoIsOnCompletedList(String completedName) {
        By completedFilterElement = By.cssSelector(".filters [href=\"#/completed\"]");
        By todoListElement = By.cssSelector(".todo-list");
        browser.findElement(completedFilterElement).click();
        WebElement todos = browser.findElement(todoListElement);
        assertThat("Completed todo is on completed list", todos.getText(), containsString(completedName));
    }
}
