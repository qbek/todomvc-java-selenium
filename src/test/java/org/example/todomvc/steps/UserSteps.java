package org.example.todomvc.steps;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserSteps {

    By newTodoInputEl = By.cssSelector(".new-todo");
    By todoListEl = By.cssSelector(".todo-list");

    By todoItemEl = By.cssSelector(".todo-list li");
    By completeButtonEl = By.cssSelector(".toggle");

    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    WebDriver browser;

    public UserSteps (WebDriver browser) {
        this.browser = browser;
    }


    public void userChecksIfTaskIsOnCompletedTab(String taskName) {
        WebElement completedTab = browser.findElement(completeTabEl);
        completedTab.click();

        WebElement todoList = browser.findElement(todoListEl);
        MatcherAssert.assertThat("Todo should be on the list", todoList.getText(), Matchers.equalTo(taskName));
    }

    public void userChecksIfTaskInNOTOnActiveTab(String taskName) {
        WebElement activeTab = browser.findElement(activeTabEl);
        activeTab.click();

        List<WebElement> todoList = browser.findElements(todoListEl);
        MatcherAssert.assertThat("Task should not be on the Active list", todoList, Matchers.hasSize(0));
    }

    public void userChecksIfTaskIsMarkedAsCompleted() {
        WebElement taskItem = browser.findElement(todoItemEl);
        String taskClasses = taskItem.getAttribute("classssss");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    public void userCompletesTheTask() {
        WebElement completedButton = browser.findElement(completeButtonEl);
        completedButton.click();
    }

    public void userChecksIfTaskCreated(String todoName) {
        //User checks if todo is created
        WebElement todoItem = browser.findElement(todoListEl);
        MatcherAssert.assertThat("Todo has correct name", todoItem.getText(), Matchers.equalTo(todoName));
    }

    public void userCreatesANewTask(String todoName) {
        WebElement newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    public void userOpensTodoMVCapp() {
        browser.get("https://todomvc.com/examples/angular/dist/browser/#/all");
    }
}
