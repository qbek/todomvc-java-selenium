package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.NewTodoInput;
import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoMVCApp;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.By;

public class UserSteps {

    @Steps
    NewTodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoFilters filters;

    @Steps
    TodoMVCApp app;


    @Step
    public void userChecksIfCompletedTaskIsOnCompletedTab(String todoName) {
       filters.goToCompletedTab();
       todosList.checkIfTodoIsListed(todoName);
    }

    @Step
    public void userChecksIfCompletedTaskIsNotOnActiveTab(String todoName) {
        filters.goToActiveTab();
        todosList.checkIfTodoIsNotListed(todoName);
    }

    @Step
    public void userChecksIfTodoIsMarkedAsCompleted() {
        todosList.checkIfTodoCompleted();

    }

    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userChecksIfTodoIsCreated(String todoName) {
        todosList.checkIfTodoIsListed(todoName);
    }

    @Step
    public void userAddsANewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }

    @Step
    public void userOpensTodoMVCApp() {
        app.openTodoMVC();
    }

    @Step
    public void userClosesTodoMVCApp() {
        app.closeTodoMVC();
    }
}
