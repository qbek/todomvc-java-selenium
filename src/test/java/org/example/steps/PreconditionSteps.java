package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PreconditionSteps {

    @Steps
    UserActionSteps steps;

    @Step
    public void userHasCompletedTodo() {
        steps.userCreatesNewTask();
        steps.userCompletesTheTask();
    }

    @Step
    public void userHasCreatedTodo() {
        steps.userCreatesNewTask();
    }
}
