package org.example.steps;

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

    public void userCreatesANewTodo(String name) {
        todoInput.enterTodoName(name);
        todoInput.submitTodo();
    }

    public void userChecksIfTodoIsListed(String name) {
        todoList.checkListContainsAnyTodo();
        var todosList = Arrays.asList(name);
        todoList.userCheckAllTodos(todosList);
    }

    public void userCompletesTodo() {
        todoList.completeTodo();
    }

    public void userChecksIfTodoMarkedAsCompleted() {
        todoList.checkIsTodoMarkedAsCompleted();
    }

    public void userGoesToActiveTodos() {
        todoFilters.gotoActive();
    }

    public void userChecksIfListIsEmpty() {
        todoList.checkTodoListIsEmpty();
    }

    public void userGoesToCompletedTodos() {
        todoFilters.gotoCompleted();
    }

    public void userCreatesFewTodos(List<String> todosNames) {
        for (var name : todosNames) {
            userCreatesANewTodo(name);
        }
    }

    public void userChecksAllTodos(List<String> todosNames) {
        todoList.userCheckAllTodos(todosNames);
    }
}
