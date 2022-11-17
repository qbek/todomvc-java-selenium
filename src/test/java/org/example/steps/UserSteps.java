package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.NewTodo;
import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoMvcApp;
import org.example.pageobjects.TodosList;

public class UserSteps {

    @Steps
    NewTodo newTodoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoFilters todoFilters;

    @Steps
    TodoMvcApp app;

    @Step
    public void userChecksIfTodoIsOnTheList(String taskName) {
        todosList.checkIfTodoDisplayed(taskName);
    }

    @Step
    public void userCreatesNewTask(String taskName) {
        newTodoInput.createTask(taskName);
    }

    @Step
    public void userChecksIfTaskIsOnCompletedTab(String taskName) {
        todoFilters.switchToCompleted();
        todosList.checkIfTodoDisplayed(taskName);
    }

    @Step
    public void userChecksIfTaskInNOTOnActiveTab(String taskName) {
        todoFilters.switchToActive();
        todosList.checkIfTodoNOTDisplayed(taskName);
    }

    @Step
    public void userChecksIfTaskIsMarkedAsCompleted() {
        todosList.checkIfTodoMarkedAsCompleted();
    }

    @Step
    public void userCompletesTheTask() {
        todosList.completeTodo();
    }

    @Step
    public void userOpensTodoMVCApp() {
        app.openTodoMVC();
    }
}
