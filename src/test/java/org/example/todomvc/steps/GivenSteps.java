package org.example.todomvc.steps;

import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.TodoMVCApp;

public class GivenSteps {

    @Steps
    private TodoMVCApp app;
    @Steps
    private WhenSteps when;

    public void userHasTodoMvcAppOpened() {
        app.openTodoMVCPage();
    }

    public void userHasTodoCreated(String todoName) {
        when.userCreatesANewTodo(todoName);
    }

    public void userHasCompletedTodo(String todoName) {
        userHasTodoCreated(todoName);
        when.userCompletesTodo();
    }
}
