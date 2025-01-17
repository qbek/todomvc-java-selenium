package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

public class UserPreconditions {

    @Steps(shared = true)
    UserActions actions;


    @Step
    public void userHasTodoCreated(String name) {
        actions.userOpensTodoMVCapp();
        actions.userCreatesANewTodo(name);
    }

    public void userHasCompletedTodo(String name) {
        actions.userOpensTodoMVCapp();
        actions.userCreatesANewTodo(name);
        actions.userCompletesTodo();
    }
}
