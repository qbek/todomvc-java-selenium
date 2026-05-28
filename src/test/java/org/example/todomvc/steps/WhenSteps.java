package org.example.todomvc.steps;

import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.openqa.selenium.WebDriver;

public class WhenSteps {

    private TodoMVCApp app;
    private NewTodoInputPO newTodoInput;
    private TodosListPO todosList;
    private TodoFiltersPO todoFilters;

    public WhenSteps (WebDriver browser) {
        app = new TodoMVCApp(browser);
        newTodoInput = new NewTodoInputPO(browser);
        todosList = new TodosListPO(browser);
        todoFilters = new TodoFiltersPO(browser);
    }


    public void userCreatesANewTodo(String todoName) {
        newTodoInput.enterTodoName(todoName);
        newTodoInput.submitTodo();
    }

    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    public void userGoesToActiveTodos() {
        todoFilters.gotoActiveTodos();
    }

    public void userGoesToCompletedTodos() {
        todoFilters.gotoCompletedTodos();
    }
}
