package org.example.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.Filters;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMvcApp;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class UserActions {

    @Steps
    TodoInput todoInput;

    @Steps
    Filters filters;

    @Steps
    TodosList todosList;

    @Steps
    TodoMvcApp app;

    @Step
    public void userOpensTodoMvcApplication() {
        app.openTodoMVC();
        todoInput.waitForReady();
    }

    @Step
    public void userCreatesANewTodo(String name) {
        todoInput.createNewTodo(name);
    }

    @Step
    public void userChecksIfTodoWasCreated(String expectedName) {
        todosList.checkIfTodoIsOnTheList(expectedName);
    }

    @Step
    public void userCompletesTheTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userChecksIfTodoIsMarkedAsCompleted() {
        todosList.checkIfTodoIsMarkedAsCompleted();
    }

    @Step
    public void userChecksIfCompletedTodoIsNOTonActiveList(String completedName) {
        filters.switchToActive();
        todosList.checkIfTodoIsNOTonTheList(completedName);
    }

    @Step
    public void userChecksIfCompletedTodoIsOnCompletedList(String completedName) {
        filters.switchToCompleted();
        todosList.checkIfTodoIsOnTheList(completedName);
    }
}
