package org.example.steps;

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

    public void userChecksIfTodoIsOnTheList(String taskName) {
        todosList.checkIfTodoDisplayed(taskName);
    }

    public void userCreatesNewTask(String taskName) {
        newTodoInput.createTask(taskName);
    }


    public void userChecksIfTaskIsOnCompletedTab(String taskName) {
        todoFilters.switchToCompleted();
        todosList.checkIfTodoDisplayed(taskName);
    }

    public void userChecksIfTaskInNOTOnActiveTab(String taskName) {
        todoFilters.switchToActive();
        todosList.checkIfTodoNOTDisplayed(taskName);
    }

    public void userChecksIfTaskIsMarkedAsCompleted() {
        todosList.checkIfTodoMarkedAsCompleted();
    }

    public void userCompletesTheTask() {
        todosList.completeTodo();
    }

    public void userOpensTodoMVCApp() {
        app.openTodoMVC();
    }
}
