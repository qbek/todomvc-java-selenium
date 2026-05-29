package org.example.todomvc.steps;

import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.openqa.selenium.WebDriver;

public class WhenSteps {

    @Steps
    private TodoMVCApp app;
    @Steps
    private NewTodoInputPO newTodoInput;
    @Steps
    private TodosListPO todosList;
    @Steps
    private TodoFiltersPO todoFilters;


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
