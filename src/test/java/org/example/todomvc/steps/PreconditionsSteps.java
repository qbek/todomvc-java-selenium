package org.example.todomvc.steps;

import net.serenitybdd.annotations.Steps;

public class PreconditionsSteps {

    @Steps(shared = true)
    private UserSteps steps;


    public void userHasTodoCreated(String name) {
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(name);
    }
}
