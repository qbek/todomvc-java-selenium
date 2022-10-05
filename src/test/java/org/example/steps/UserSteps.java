package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCapp;
import org.example.pageobjects.TodosFilters;
import org.example.pageobjects.TodosList;

public class UserSteps {

    @Steps
    TodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoMVCapp todoMvc;

    @Steps
    TodosFilters todosFilters;

    @Step
    public void userChecksIfCompletedTodoIsOnCompletedFilter(String name) {
        todosFilters.switchToCompleteTab();
        todosList.checkIfTodoIsDisplayed(name);
    }

    @Step("User checks if completed task is filtered out on Active tab")
    public void userChecksIfCompletedTodoIsNotOnActiveFilter(String name) {
        todosFilters.switchToActiveTab();
        todosList.checkIfTodoIsNOTDisplayed(name);
    }

    @Step
    public void userChecksItTodoIsMarkedAsCompleted() {
        todosList.checkIfTodoMarkedAsCompleted();
    }

    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step("User checks it todo was created")
    public void userChecksIfTodoWasCreated(String todoName) {
        todosList.checkIfTodoIsDisplayed(todoName);
    }

    public void userOpenTodoMVC() {
        todoMvc.openApp();
    }

    @Step("User creates a new todo")
    public void userCreatesANewTodo(String name) {
        todoInput.addTodo(name);
    }

    @Step("User has completed todo")
    public void userHasCompleteTodo(String name) {
        userCreatesANewTodo(name);
        userChecksIfTodoWasCreated(name);
        userCompletesTodo();
    }
}
