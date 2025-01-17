package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInput;
import org.example.todomvc.pageobjects.TodoFilters;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosList;

import java.util.Arrays;
import java.util.List;

public class UserActions {

    String todoName;
    List<String> todosNames;

    @Steps
    NewTodoInput newTodoInput;
    @Steps
    TodosList todosList;
    @Steps
    TodoFilters todoFilters;
    @Steps
    TodoMVCApp todoMVCApp;


    @Step
    public void userChecksIfCompletedTodoIsOnCompletedTab() {
        todoFilters.goToCompletedTab();
        todosList.checkAllTodosAreOnTheList(Arrays.asList(todoName));
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
        todosList.checkAllTodosAreOnTheList(Arrays.asList(todoName));
    }

    public void userCreatesAFewTodos(List<String> names) {
        this.todosNames = names;
        for ( var name : todosNames) {
            newTodoInput.enterTodoName(name);
            newTodoInput.submitTodo();
        }

    }

    public void userChecksIfAllTodosAreCreated(List<String> todos) {
        todosList.checkAllTodosAreOnTheList(todos);
    }
}

