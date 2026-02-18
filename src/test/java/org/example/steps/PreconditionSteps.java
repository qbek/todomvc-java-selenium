package org.example.steps;

import net.serenitybdd.annotations.Steps;


public class PreconditionSteps {

    @Steps
    UserSteps steps;

    public void userHasTodoCreated(String todoName) {
      steps.userCreatesANewTodo(todoName);
    }

    public void userHasCompletedTodo(String todoName) {
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTodo();
    }
}
