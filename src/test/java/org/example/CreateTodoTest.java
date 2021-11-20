package org.example;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import org.apache.xerces.impl.xpath.regex.Match;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CreateTodoTest {

    WebDriver browser = new FirefoxDriver();

    @After
    public void finishTest() {
        browser.close();
    }

    @Test
    public void user_can_create_a_new_todo() throws InterruptedException {
        String todoName = "Nauczyć się automatyzacji testów";
        userOpensTodoMvcApplication();
        userCreatesANewTodo(todoName);
        userChecksIfTodoWasCreated(todoName);
    }

    @Test
    public void user_can_complete_the_todo() throws InterruptedException {
        String todoName = "Zadanie do zakończenia";
        userOpensTodoMvcApplication();
        userCreatesANewTodo(todoName);
        userCompletesTheTodo();
        userChecksIfTodoIsMarkedAsCompleted();
        userChecksIfCompletedTodoIsNOTonActiveList(todoName);
        userChecksIfCompletedTodoIsOnCompletedList(todoName);
    }

    private void userOpensTodoMvcApplication() throws InterruptedException {
        int sleepTime = 1000;
        String todoMVC_URL = "https://todomvc.com/examples/jquery/#/all";
        browser.get(todoMVC_URL);
        Thread.sleep(sleepTime);
    }

    private void userCreatesANewTodo(String name) {
        By inputTodo = By.cssSelector(".new-todo");
        WebElement newTodoInput = browser.findElement(inputTodo);
        newTodoInput.sendKeys(name);
        newTodoInput.sendKeys(Keys.RETURN);
    }

    private void userChecksIfTodoWasCreated(String expectedName) {
        By todoList = By.cssSelector(".todo-list li");
        WebElement todos = browser.findElement(todoList);
        String todoName = todos.getText();
        assertThat("Todo list shoudl contain created todo", todoName, equalTo(expectedName));
    }

    private void userCompletesTheTodo() {
        By completeToggle = By.cssSelector(".todo-list li .toggle");
        WebElement toComplete = browser.findElement(completeToggle);
        toComplete.click();
    }

    private void userChecksIfTodoIsMarkedAsCompleted() {
        String completitionMark = "completed";
        By todoElement = By.cssSelector(".todo-list li");
        WebElement todo = browser.findElement(todoElement);
        String todoClasses = todo.getAttribute("class");
        assertThat("Todo should be marked as completed", todoClasses, equalTo(completitionMark));
    }

    private void userChecksIfCompletedTodoIsNOTonActiveList(String completedName) {
        By activeFilterElement = By.cssSelector(".filters [href=\"#/active\"]");
        By todoListElement = By.cssSelector(".todo-list");
        browser.findElement(activeFilterElement).click();
        WebElement todos = browser.findElement(todoListElement);
        assertThat("Completed todo is not on active list", todos.getText(), not(containsString(completedName)));
    }

    private void userChecksIfCompletedTodoIsOnCompletedList(String completedName) {
        By completedFilterElement = By.cssSelector(".filters [href=\"#/completed\"]");
        By todoListElement = By.cssSelector(".todo-list");
        browser.findElement(completedFilterElement).click();
        WebElement todos = browser.findElement(todoListElement);
        assertThat("Completed todo is on completed list", todos.getText(), containsString(completedName));
    }
}
