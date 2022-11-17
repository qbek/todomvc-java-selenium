package org.example.steps;

import com.github.javafaker.Faker;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.NewTodo;
import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoMvcApp;
import org.example.pageobjects.TodosList;

import java.io.IOException;
import java.util.List;

public class UserSteps {

    private String taskName;

    private Faker generator = new Faker();

    @Steps
    NewTodo newTodoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoFilters todoFilters;

    @Steps
    TodoMvcApp app;

    @Step
    public void userChecksIfTodoIsOnTheList() {
        todosList.checkIfTodoDisplayed(this.taskName);
    }

    @Step
    public void userCreatesNewTask() {
        this.taskName = generator.funnyName().name();
        newTodoInput.createTask(this.taskName);
    }

    @Step
    public void userChecksIfTaskIsOnCompletedTab() {
        todoFilters.switchToCompleted();
        todosList.checkIfTodoDisplayed(this.taskName);
    }

    @Step
    public void userChecksIfTaskInNOTOnActiveTab() {
        todoFilters.switchToActive();
        todosList.checkIfTodoNOTDisplayed(this.taskName);
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
    public void userOpensTodoMVCApp() throws IOException {
        app.openTodoMVC();
    }

    @Step
    public void userChecksIfTodoIsNotOnTheList() {
        todosList.checkIfTodoNOTDisplayed(this.taskName);
    }

    @Step
    public void userDeletesTask() {
        todosList.deleteTask();
    }

    @Step
    public void userCreatesFewTodos() {
        List<String> tasks = generator.lorem().sentences(
                generator.number().numberBetween(0, 4)
        );
        for (String task : tasks) {
            newTodoInput.createTask(task);
        }
    }

    @Step
    public void userCreateTheOne() {
        newTodoInput.createTask("THE ONE!!!");
    }

    @Step
    public void userDeletesTheOne() {
        todosList.deleteTask("THE ONE!!!");
    }
}
