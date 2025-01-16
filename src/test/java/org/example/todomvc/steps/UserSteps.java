package org.example.todomvc.steps;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserSteps {

    String todoName;
    String todoMVCUrl = "https://todomvc.com/examples/jquery/dist/#/all";

    By newTodoInputEl = By.cssSelector("#new-todo");
    By todosListEl = By.cssSelector("#todo-list");
    By todoItemEl = By.cssSelector("#todo-list li");

    By todoCompleteToggleEl = By.cssSelector(".toggle");

    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    WebDriver browser = new FirefoxDriver();


    public void userChecksIfCompletedTodoIsOnCompletedTab() {
        var completedFilter = browser.findElement(completeTabEl);
        completedFilter.click();
        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(todoName));
    }

    public void userChecksIfCompletedTodoIsNotOnActiveTab() {
        var activeFilter = browser.findElement(activeTabEl);
        activeFilter.click();
        var todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Todo is not on the Active list", todosList.getText(), Matchers.emptyOrNullString());
    }

    public void userChecksIfTodoMarkedAsCompleted() {
        var todoItem = browser.findElement(todoItemEl);

        //sprawdzenie czy element isnieje na stronie (czyste selenium)
        var completeTodo = browser.findElements(By.cssSelector(".completed"));
        MatcherAssert.assertThat("Completed todo is displayed", completeTodo, Matchers.hasSize(1));

        MatcherAssert.assertThat("Todo is marked as completed", todoItem.getDomAttribute("class"), Matchers.containsString("completed"));
    }

    public void userCompletesTodo() {
        var completeTodoToggleEl = browser.findElement(todoCompleteToggleEl);
        completeTodoToggleEl.click();
    }

    public void userOpensTodoMVCapp() {
        browser.get(todoMVCUrl);
    }

    public void userCreatesANewTodo(String name) {
        this.todoName = name;
        var newTodoInput = browser.findElement(newTodoInputEl);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);
    }

    public void userChecksIfTodoIsCreated() {
        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(todoName));
    }

    public void userClosesTodoMVCApp() {
        browser.close();
    }
}
