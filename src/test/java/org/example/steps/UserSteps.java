package org.example.steps;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UserSteps {

    private WebDriver browser;

    public UserSteps(WebDriver browser) {
        this.browser = browser;
    }

    public void userChecksIfCompletedTodoIsOnCompletedFilter(String name) {
        var completedFilter = browser.findElement(By.cssSelector("[href=\"#/completed\""));
        completedFilter.click();

        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo is not on the list", todos, Matchers.equalTo(name));
    }

    public void userChecksIfCompletedTodoIsNotOnActiveFilter(String name) {
        var activeFilter = browser.findElement(By.cssSelector("[href=\"#/active\""));
        activeFilter.click();

        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo is not on the list", todos, Matchers.emptyOrNullString());
    }

    public void userChecksItTodoIsMarkedAsCompleted() {
//        var todoElement = browser.findElement(By.cssSelector(".todo-list > li"));
//        var todoClasses = todoElement.getAttribute("class");
//        MatcherAssert.assertThat("Todo should be marked as completed", todoClasses, Matchers.equalTo("completed"));

        var todoElements = browser.findElements(By.cssSelector(".todo-list > .completed"));
        MatcherAssert.assertThat("Todo marked as completed is on the list", todoElements.size(), Matchers.equalTo(1));
    }

    public void userCompletesTodo() {
        var todoCompleteToggle = browser.findElement(By.cssSelector(".toggle"));
        todoCompleteToggle.click();
    }


    public void userChecksIfTodoWasCreated(String todoName) {
        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.equalTo(todoName));
    }

    public void userOpenTodoMVC() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }

    public void userCreatesANewTodo(String name) {
        var todoInput = browser.findElement(By.cssSelector(".new-todo"));
        todoInput.sendKeys(name);
        todoInput.sendKeys(Keys.RETURN);
    }
}
