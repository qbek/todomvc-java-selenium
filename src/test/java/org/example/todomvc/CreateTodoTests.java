package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests {

    String todoName = "Moje super zadanie";
    String todoMVCUrl = "https://todomvc.com/examples/jquery/dist/#/all";

    By newTodoInputEl = By.cssSelector("#new-todo");
    By todosListEl = By.cssSelector("#todo-list");
    By todoItemEl = By.cssSelector("#todo-list li");

    By todoCompleteToggleEl = By.cssSelector(".toggle");

    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    WebDriver browser = new FirefoxDriver();

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

    @Test
    public void userCanCreateATodo() {
        userOpensTodoMVCapp();
        userCreatesANewTodo();
        userChecksIfTodoIsCreated();
    }

    @Test
    public void userCanCompleteATodo() {
        userOpensTodoMVCapp();
        userCreatesANewTodo();
        userCompletesTodo();
        userChecksIfTodoMarkedAsCompleted();
        userChecksIfCompletedTodoIsNotOnActiveTab();
        userChecksIfCompletedTodoIsOnCompletedTab();
    }

    private void userChecksIfCompletedTodoIsOnCompletedTab() {
        var completedFilter = browser.findElement(completeTabEl);
        completedFilter.click();
        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(todoName));
    }

    private void userChecksIfCompletedTodoIsNotOnActiveTab() {
        var activeFilter = browser.findElement(activeTabEl);
        activeFilter.click();
        var todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Todo is not on the Active list", todosList.getText(), Matchers.emptyOrNullString());
    }

    private void userChecksIfTodoMarkedAsCompleted() {
        var todoItem = browser.findElement(todoItemEl);

        //sprawdzenie czy element isnieje na stronie (czyste selenium)
        var completeTodo = browser.findElements(By.cssSelector(".completed"));
        MatcherAssert.assertThat("Completed todo is displayed", completeTodo, Matchers.hasSize(1));

        MatcherAssert.assertThat("Todo is marked as completed", todoItem.getDomAttribute("class"), Matchers.containsString("completed"));
    }

    private void userCompletesTodo() {
        var completeTodoToggleEl = browser.findElement(todoCompleteToggleEl);
        completeTodoToggleEl.click();
    }

    private void userOpensTodoMVCapp() {
        browser.get(todoMVCUrl);
    }

    private void userCreatesANewTodo() {
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    private void userChecksIfTodoIsCreated() {
        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(todoName));
    }
}
