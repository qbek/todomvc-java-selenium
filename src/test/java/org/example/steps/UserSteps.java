package org.example.steps;

import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class UserSteps {

    WebDriver browser;
    TodoInput todoInput;
    TodosList todoList;
    TodoFilters todoFilters;

    public UserSteps(WebDriver browser) {
        this.browser = browser;
        todoInput = new TodoInput(browser);
        todoList = new TodosList(browser);
        todoFilters = new TodoFilters(browser);
    }

    public void userCreatesANewTodo(String name) {
        todoInput.enterTodoName(name);
        todoInput.submitTodo();
    }

    public void userChecksIfTodoIsListed(String name) {
        todoList.checkListContainsAnyTodo();
        todoList.checkTodoHasCorrectName(name);
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
