package org.example.todomvc.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.ENTER;

public class UserSteps {

    private By newTodoInputEl = cssSelector(".new-todo");
    private By todoListEl = cssSelector(".todo-list");
    private By todoEl = cssSelector(".todo-list li");
    private By completedFilterEl = cssSelector("[href=\"#/completed\"]");
    private By activeFilterEl = cssSelector("[href=\"#/active\"]");
    private By completeTodoToggleEl = cssSelector(".toggle");

    private String todoMvcURL = "https://todomvc.com/examples/angular/dist/browser/#";

    private WebDriver browser = new FirefoxDriver();

    public void userChecksIfCompletedTodoIsOnCompletedList(String todoName) {
        var completedFilter = browser.findElement(completedFilterEl);
        completedFilter.click();
        var todoList = browser.findElement(todoListEl);
        assertThat("Todo is on completed list", todoList.getText(), equalTo(todoName));
    }

    public void userChecksIfCompltedTodoIsNotOnActiveList() {
        var activeFilter = browser.findElement(activeFilterEl);
        activeFilter.click();

        //jquery solution
//        var todoList = browser.findElement(todoListEl);
//        assertThat("Todo is not on the Active filter list", todoList.getText(), is(emptyString()));

        //angular solution
        var todoList = browser.findElements(todoListEl);
        assertThat("Todo is not on the Active filter list", todoList, hasSize(0));
    }

    public void userChecksIfTodoMarkedAsCompleted() {
        var todoItem = browser.findElement(todoEl);
        assertThat("Todo is marked as completed", todoItem.getAttribute("class"), containsString("completed"));
    }

    public void userCompletesTodo() {
        var completeToggle = browser.findElement(completeTodoToggleEl);
        completeToggle.click();
    }

    public void userOpensTodoMVCapp() {
        browser.get(todoMvcURL);
    }

    public void userClosesTodoMVCapp() {
        browser.close();
    }

    public void userCreatesANewTodo(String name) {
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(name);
        newTodoInput.sendKeys(ENTER);
    }

    public void userChecksIfTodoIsCreated(String expectedName) {
        var todoItem = browser.findElement(todoListEl);
        assertThat("Todo has correct name", todoItem.getText(), equalTo(expectedName));
    }
}
