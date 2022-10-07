package org.example.steps;

import com.github.javafaker.Faker;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCapp;
import org.example.pageobjects.TodosFilters;
import org.example.pageobjects.TodosList;

import java.util.List;

public class UserSteps {

    Faker dataGenerator = new Faker();

    @Steps
    TodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoMVCapp todoMvc;

    @Steps
    TodosFilters todosFilters;

    private String todoName;

    @Step
    public void userChecksIfCompletedTodoIsOnCompletedFilter() {
        todosFilters.switchToCompleteTab();
        todosList.checkIfTodoIsDisplayed(todoName);
    }

    @Step("User checks if completed task is filtered out on Active tab")
    public void userChecksIfCompletedTodoIsNotOnActiveFilter() {
        todosFilters.switchToActiveTab();
        todosList.checkIfTodoIsNOTDisplayed(todoName);
    }

    @Step
    public void userChecksItTodoIsMarkedAsCompleted() {
        todosList.checkIfTodoMarkedAsCompleted();
    }

    @Step
    public void userCompletesTodo() {
        todosList.completeTodo(todoName);
    }

    @Step("User checks it todo was created")
    public void userChecksIfTodoWasCreated() {
        todosList.checkIfTodoIsDisplayed(todoName);
    }

    public void userOpenTodoMVC() {
        todoMvc.openApp();
        todoInput.waitUntilVisible();
    }

    @Step("User creates a new todo")
    public void userCreatesANewTodo() {
        todoName = dataGenerator.witcher().monster();
        todoInput.addTodo(todoName);
    }

    public void userCreatesANewTodo(String name) {
        todoInput.addTodo(name);
    }

    @Step("User has completed todo")
    public void userHasCompletedTodo() {
        userCreatesANewTodo();
        userChecksIfTodoWasCreated();
        userCompletesTodo();
    }

    public void userAddsFewTodos(List<String> fewTodos) {
        for (String todo : fewTodos) {
            userCreatesANewTodo(todo);
        }
    }

    public void userCompletesTheOne() {
        todosList.completeTodo("THE ONE");
    }

    public void userWaitsForStopTodo() {
        todosList.waitForTodo("STOP");
    }
}
