package org.example.todomvc.steps;

import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.openqa.selenium.WebDriver;

public class ThenSteps {

    @Steps
    private TodoMVCApp app;
    @Steps
    private NewTodoInputPO newTodoInput;
    @Steps
    private TodosListPO todosList;
    @Steps
    private TodoFiltersPO todoFilters;


    public void userCheckTodoIsOnTodosList(String todoName) {
        todosList.checkTodoIsOnTheList(todoName);
    }

    public void userChecksTodoIsCompleted() {
        todosList.checkTodoMarkedAsCompleted();
    }

    public void userChecksTodosListIsEmpty() {
        todosList.checkTodoListIsEmpty();
    }
}
