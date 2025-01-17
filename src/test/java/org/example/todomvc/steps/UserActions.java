package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import org.example.todomvc.pageobjects.NewTodoInput;
import org.example.todomvc.pageobjects.TodoFilters;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosList;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserActions {

    String todoName;

    WebDriver browser = new FirefoxDriver();

    NewTodoInput newTodoInput = new NewTodoInput(browser);
    TodosList todosList = new TodosList(browser);
    TodoFilters todoFilters = new TodoFilters(browser);
    TodoMVCApp todoMVCApp = new TodoMVCApp(browser);


    @Step
    public void userChecksIfCompletedTodoIsOnCompletedTab() {
        todoFilters.goToCompletedTab();
        todosList.checkTodoIsOnTheList(todoName);
    }

    @Step
    public void userChecksIfCompletedTodoIsNotOnActiveTab() {
        todoFilters.goToActiveTab();
        todosList.checkTodosListIsEmpty();
    }

    @Step
    public void userChecksIfTodoMarkedAsCompleted() {
        todosList.checkTodoItemHasCompletedClass();
    }

    @Step
    public void userCompletesTodo() {
        todosList.markTodoAsCompleted();
    }

    @Step("User opens super hiper TodoMVC web application")
    public void userOpensTodoMVCapp() {
        todoMVCApp.openMainView();
    }

    @Step("User creates a new todo with name: {0}")
    public void userCreatesANewTodo(String name) {
        this.todoName = name;
        newTodoInput.enterTodoName(todoName);
        newTodoInput.submitTodo();
    }

    @Step
    public void userChecksIfTodoIsCreated() {
        todosList.checkTodoIsOnTheList(todoName);
    }

    @Step
    public void userClosesTodoMVCApp() {
        browser.close();
    }
}

