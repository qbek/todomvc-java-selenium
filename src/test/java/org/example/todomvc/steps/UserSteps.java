package org.example.todomvc.steps;

import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TaskFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCapp;
import org.example.todomvc.pageobjects.TodosListPO;

public class UserSteps {

    private NewTodoInputPO todoInput ;
    private TodosListPO todosList;
    private TodoMVCapp todoMVC;
    private TaskFiltersPO taskFilters;

    public UserSteps () {
        todoInput = new NewTodoInputPO();
        todosList = new TodosListPO();
        todoMVC = new TodoMVCapp();
        taskFilters = new TaskFiltersPO();
    }

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

    public void userChecksIfTaskCreated(String todoName) {
        todosList.checkIfTaskExists(todoName);
    }

    public void userCreatesANewTask(String todoName) {
        todoInput.enterTaskName(todoName);
        todoInput.submitTask();
    }

    public void userOpensTodoMVCapp() {
        todoMVC.openTodoMVC();
    }
}
