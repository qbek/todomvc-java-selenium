package org.example.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCApp;
import org.example.pageobjects.TodosList;

import java.util.ArrayList;
import java.util.List;

import static org.example.data.TestDataManager.setupTodosNamesTestData;
import static org.example.data.TestDataTypes.TODOS_NAMES;

public class UserActions {

    @Steps
    TodoInput todoInput;
    @Steps
    TodosList todosList;


    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userCreatesNewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }


    @Step
    public void userCreatesFewTodos() {
        setupTodosNamesTestData();
        var todosNames = (List<String>) Serenity.sessionVariableCalled(TODOS_NAMES);
        todosNames.forEach( name -> todoInput.createNewTodo(name));
    }

    @Step
    public void userDeletesTodo() {
        todosList.deleteTodo();
    }

    @Step
    public void userDeletesTodo(String name) {
        todosList.deleteTodo(name);
    }
}
