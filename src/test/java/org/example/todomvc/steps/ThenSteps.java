package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;

public class ThenSteps {

    @Steps
    private TodoMVCApp app;
    @Steps
    private NewTodoInputPO newTodoInput;
    @Steps
    private TodosListPO todosList;
    @Steps
    private TodoFiltersPO todoFilters;

    @Step
    public void userCheckTodoIsOnTodosList(String todoName) {
        todosList.checkTodoIsOnTheList(todoName);
    }

    @Step
    public void userChecksTodoIsCompleted() {
        todosList.checkTodoMarkedAsCompleted();
    }

    @Step
    public void userChecksTodosListIsEmpty() {
        todosList.checkTodoListIsEmpty();
    }
}
