package org.example.steps;

import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.NewTodo;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSteps {
    WebDriver browser;

    By todoInputSelector = By.cssSelector(".new-todo");
    By todoListSelector = By.cssSelector(".todo-list");
    By todoItemSelector = By.cssSelector(".todo-list li");
    By completeButtonSelector = By.cssSelector(".todo-list li .toggle");

    By completeTabSelector = By.cssSelector("[href=\"#/completed\"]");
    By activeTabSelector = By.cssSelector("[href=\"#/active\"]");

    @Steps
    NewTodo newTodoInput;

    public void setDriver(WebDriver browser) {
        this.browser = browser;
    }

    public void userChecksIfTodoIsOnTheList(String taskName) {
        WebElement todosList = browser.findElement(todoListSelector);
        String todos = todosList.getText();
        MatcherAssert.assertThat("Todo should be on the list", todos, Matchers.equalTo(taskName));
    }

    public void userCreatesNewTask(String taskName) {
        newTodoInput.createTask(taskName);
    }


    public void userChecksIfTaskIsOnCompletedTab(String taskName) {
        WebElement completeTab = browser.findElement(completeTabSelector);
        completeTab.click();

        WebElement todoList = browser.findElement(todoListSelector);
        MatcherAssert.assertThat("Todo should be on the list", todoList.getText(), Matchers.equalTo(taskName));
    }

    public void userChecksIfTaskInNOTOnActiveTab(String taskName) {

        WebElement activeTab = browser.findElement(activeTabSelector);
        activeTab.click();

        WebElement todoList = browser.findElement(todoListSelector);
        MatcherAssert.assertThat("Task should not be on the Active list", todoList.getText(), Matchers.not(Matchers.containsString(taskName)));
    }

    public void userChecksIfTaskIsMarkedAsCompleted() {
        WebElement taskItem = browser.findElement(todoItemSelector);
        String taskClasses = taskItem.getAttribute("class");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    public void userCompletesTheTask() {
        WebElement completedButton = browser.findElement(completeButtonSelector);
        completedButton.click();
    }

    public void userOpensTodoMVCApp() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }
}
