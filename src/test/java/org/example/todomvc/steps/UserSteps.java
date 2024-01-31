package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TaskFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCapp;
import org.example.todomvc.pageobjects.TodosListPO;

public class UserSteps {

    @Steps
    private NewTodoInputPO todoInput ;
    @Steps
    private TodosListPO todosList;
    @Steps
    private TodoMVCapp todoMVC;
    @Steps
    private TaskFiltersPO taskFilters;

    public void userChecksIfTaskIsOnCompletedTab(String taskName) {
        taskFilters.gotoCompletedTasks();
        todosList.checkIfTaskExists(taskName);
    }

    public void userChecksIfTaskInNOTOnActiveTab() {
        taskFilters.gotoActiveTasks();
        todosList.checkIfTaskNotExists();
    }

    public void userChecksIfTaskIsMarkedAsCompleted() {
        todosList.checkIfTaskCompleted();
    }

    public void userCompletesTheTask() {
        todosList.completeTask();
    }

    @Step
    public void userChecksIfTaskCreated(String todoName) {
        todosList.checkIfTaskExists(todoName);
    }

    @Step
    public void userCreatesANewTask(String todoName) {
        todoInput.enterTaskName(todoName);
        todoInput.submitTask();
    }

    @Step
    public void userOpensTodoMVCapp() {
        todoMVC.openTodoMVC();
    }

    public void waitForTheOne() {
        todosList.waitForTheOne();
    }
}
