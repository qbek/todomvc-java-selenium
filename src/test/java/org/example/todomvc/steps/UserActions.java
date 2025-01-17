package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInput;
import org.example.todomvc.pageobjects.TodoFilters;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosList;

public class UserActions {

    String todoName;

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

}

