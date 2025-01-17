package org.example.todomvc.pageobjects;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodosList {

    By todosListEl = By.cssSelector("#todo-list");
    By todoItemEl = By.cssSelector("#todo-list li");

    By todoCompleteToggleEl = By.cssSelector(".toggle");

    WebDriver browser;

    public TodosList(WebDriver browser) {
        this.browser = browser;
    }

    public void checkTodoIsOnTheList(String name) {
        WebElement todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Created todo is displayed on the list", todosList.getText(), Matchers.equalTo(name));
    }

    public void checkTodosListIsEmpty() {
        var todosList = browser.findElement(todosListEl);
        MatcherAssert.assertThat("Todo is not on the Active list", todosList.getText(), Matchers.emptyOrNullString());
    }

    public void checkTodoItemHasCompletedClass() {
        var todoItem = browser.findElement(todoItemEl);

        //sprawdzenie czy element isnieje na stronie (czyste selenium)
        var completeTodo = browser.findElements(By.cssSelector(".completed"));
        MatcherAssert.assertThat("Completed todo is displayed", completeTodo, Matchers.hasSize(1));

        MatcherAssert.assertThat("Todo is marked as completed", todoItem.getDomAttribute("class"), Matchers.containsString("completed"));
    }

    public void markTodoAsCompleted() {
        var completeTodoToggleEl = browser.findElement(todoCompleteToggleEl);
        completeTodoToggleEl.click();
    }
}
