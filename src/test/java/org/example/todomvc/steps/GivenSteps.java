package org.example.todomvc.steps;

import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.openqa.selenium.WebDriver;

public class GivenSteps {

    private TodoMVCApp app;
    private NewTodoInputPO newTodoInput;
    private TodosListPO todosList;
    private TodoFiltersPO todoFilters;

    private WhenSteps when;


    public GivenSteps (WebDriver browser) {
        app = new TodoMVCApp(browser);
        newTodoInput = new NewTodoInputPO(browser);
        todosList = new TodosListPO(browser);
        todoFilters = new TodoFiltersPO(browser);
        when = new WhenSteps(browser);
    }

    public void userHasTodoMvcAppOpened() {
        app.openTodoMVCPage();
    }

    public void userHasTodoCreated(String todoName) {
        when.userCreatesANewTodo(todoName);
    }

    public void userHasCompletedTodo(String todoName) {
        userHasTodoCreated(todoName);
        todosList.completeTodo();
    }
}
