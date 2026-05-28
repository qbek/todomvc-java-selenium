package org.example.todomvc.steps;

import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.openqa.selenium.WebDriver;

public class ThenSteps {

    private TodoMVCApp app;
    private NewTodoInputPO newTodoInput;
    private TodosListPO todosList;
    private TodoFiltersPO todoFilters;

    public ThenSteps (WebDriver browser) {
        app = new TodoMVCApp(browser);
        newTodoInput = new NewTodoInputPO(browser);
        todosList = new TodosListPO(browser);
        todoFilters = new TodoFiltersPO(browser);
    }


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
