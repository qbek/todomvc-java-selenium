package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class UserSteps {

    @Steps
    TodoInput todoInput;

    @Steps
    TodosList todoList;

    @Steps
    TodoFilters todoFilters;

    @Step
    public void userCreatesANewTodo(String name) {
        todoInput.enterTodoName(name);
        todoInput.submitTodo();
    }

    @Step
    public void userChecksIfTodoIsListed(String name) {
        todoList.checkListContainsAnyTodo();
        var todosList = Arrays.asList(name);
        todoList.userCheckAllTodos(todosList);
    }

    @Step
    public void userCompletesTodo() {
        todoList.completeTodo();
    }

    @Step
    public void userChecksIfTodoMarkedAsCompleted() {
        todoList.checkIsTodoMarkedAsCompleted();
    }

    @Step
    public void userGoesToActiveTodos() {
        todoFilters.gotoActive();
    }

    @Step
    public void userChecksIfListIsEmpty() {
        todoList.checkTodoListIsEmpty();
    }

    @Step
    public void userGoesToCompletedTodos() {
        todoFilters.gotoCompleted();
    }

    @Step
    public void userCreatesFewTodos(List<String> todosNames) {
        for (var name : todosNames) {
            userCreatesANewTodo(name);
        }
    }

    @Step
    public void userChecksAllTodos(List<String> todosNames) {
        todoList.userCheckAllTodos(todosNames);
    }
}
