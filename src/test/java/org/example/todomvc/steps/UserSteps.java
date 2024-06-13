package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInput;
import org.example.todomvc.pageobjects.TodoFilters;
import org.example.todomvc.pageobjects.TodoList;
import org.example.todomvc.pageobjects.TodoMVC;

public class UserSteps {
    @Steps
    private NewTodoInput newTodoInput;
    @Steps
    private TodoList todoList;
    @Steps
    private TodoFilters todoFilters;
    @Steps
    private TodoMVC todoMVC;

    @Step
    public void userChecksIfCompletedTodoIsOnCompletedList(String todoName) {
        todoFilters.gotoCompleted();
        todoList.checkIfTodoOnTheList(todoName);
    }

    @Step
    public void userChecksIfCompltedTodoIsNotOnActiveList() {
        todoFilters.gotoActive();
        todoList.checkIfTodoNOTOnTheList();
    }

    @Step
    public void userChecksIfTodoMarkedAsCompleted() {
        todoList.checkIfTodoMarkedAsCompleted();
    }

    @Step
    public void userCompletesTodo() {
        todoList.markTodoCompleted();
    }

    @Step
    public void userOpensTodoMVCapp() {
        todoMVC.openApp();
    }

    @Step("New todo wit name '{0}' is created")
    public void userCreatesANewTodo(String name) {
        newTodoInput.enterTodoName(name);
        newTodoInput.submitTodo();
    }

    @Step
    public void userChecksIfTodoIsCreated(String expectedName) {
       todoList.checkIfTodoOnTheList(expectedName);
    }
}
