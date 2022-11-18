package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PreconditionSteps {

    @Steps
    UserActionSteps steps;

    @Step
    public void userHasCompletedTask() {
        steps.userCreatesNewTask();
        steps.userCompletesTheTask();
    }

    @Step
    public void hasCreatedTodo() {
        steps.userCreatesNewTask();
    }
}
