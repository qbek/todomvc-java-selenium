package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskCreationTest {

    By todoInputSelector = By.cssSelector(".new-todo");
    By todoListSelector = By.cssSelector(".todo-list");
    By todoItemSelector = By.cssSelector(".todo-list li");
    By completeButtonSelector = By.cssSelector(".toggle");

    By completeTabSelector = By.cssSelector("[href=\"#/completed\"]");
    By activeTabSelector = By.cssSelector("[href=\"#/active\"]");

    WebDriver browser = new FirefoxDriver();

    @BeforeEach
    public void setup() {
        userOpensTodoMVCApp();
    }


    @AfterEach
    public void cleanup() {
        browser.close();
    }

    @Test
    public void userCanCreateATask() {
        String taskName = "To jest zadanie";
        userCreatesNewTask(taskName);
        userChecksIfTodoIsOnTheList(taskName);
    }

    @Test
    public void useCanCompleteATask() {
        String taskName = "Zadanie do zakończenia";
        userCreatesNewTask(taskName);
        userCompletesTheTask();
        userChecksIfTaskIsMarkedAsCompleted();
        userChecksIfTaskInNOTOnActiveTab(taskName);
        userChecksIfTaskIsOnCompletedTab(taskName);
    }

    private void userChecksIfTaskIsOnCompletedTab(String taskName) {
        WebElement completeTab = browser.findElement(completeTabSelector);
        completeTab.click();

        WebElement todoList = browser.findElement(todoListSelector);
        MatcherAssert.assertThat("Todo should be on the list", todoList.getText(), Matchers.equalTo(taskName));
    }

    private void userChecksIfTaskInNOTOnActiveTab(String taskName) {

        WebElement activeTab = browser.findElement(activeTabSelector);
        activeTab.click();

        WebElement todoList = browser.findElement(todoListSelector);
        MatcherAssert.assertThat("Task should not be on the Active list", todoList.getText(), Matchers.not(Matchers.containsString(taskName)));
    }

    private void userChecksIfTaskIsMarkedAsCompleted() {

        WebElement taskItem = browser.findElement(todoItemSelector);
        String taskClasses = taskItem.getAttribute("class");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    private void userCompletesTheTask() {

        WebElement completedButton = browser.findElement(completeButtonSelector);
        completedButton.click();
    }

    private void userChecksIfTodoIsOnTheList(String taskName) {
        WebElement todosList = browser.findElement(todoListSelector);
        String todos = todosList.getText();
        MatcherAssert.assertThat("Todo should be on the list", todos, Matchers.equalTo(taskName));
    }

    private void userCreatesNewTask(String taskName) {
        WebElement newTodoInput = browser.findElement(todoInputSelector);
        newTodoInput.sendKeys(taskName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    private void userOpensTodoMVCApp() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }
}
