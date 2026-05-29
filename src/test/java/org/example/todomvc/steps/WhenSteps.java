package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;

import java.util.List;

public class WhenSteps {

    @Steps
    private TodoMVCApp app;
    @Steps
    private NewTodoInputPO newTodoInput;
    @Steps
    private TodosListPO todosList;
    @Steps
    private TodoFiltersPO todoFilters;

    @Step
    public void userCreatesANewTodo(String todoName) {
        newTodoInput.enterTodoName(todoName);
        newTodoInput.submitTodo();
    }

    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userGoesToActiveTodos() {
        todoFilters.gotoActiveTodos();
    }

    @Step
    public void userGoesToCompletedTodos() {
        todoFilters.gotoCompletedTodos();
    }

    public void userCreatesAFewTodos(List<String> todos) {
        for (var todo :todos) {
            userCreatesANewTodo(todo);
        }
    }
}
