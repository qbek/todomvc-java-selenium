package org.example.todomvc;

import net.serenitybdd.annotations.Steps;
import org.example.todomvc.steps.PreconditionsSteps;
import org.junit.jupiter.api.Test;

public class TodoCompleteTests extends BaseTestSetup {

    @Steps
    PreconditionsSteps precondition;

    @Test
    public void userCanCompleteTodo() {
        var todoName = "jakies inne zadaie";
        precondition.userHasTodoCreated(todoName);
        steps.userCompletesTodo();
        steps.userChecksIfTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterOutCompletedTodos() {
        var todoName = "jakies inne zadaie";
        precondition.userHasTodoCreated(todoName);
        steps.userCompletesTodo();
        steps.userChecksIfCompltedTodoIsNotOnActiveList();
    }

    @Test
    public  void userCanFilterCompletexTodos() {
        var todoName = "jakies inne zadaie";
        precondition.userHasTodoCreated(todoName);
        steps.userCompletesTodo();
        steps.userChecksIfCompletedTodoIsOnCompletedList(todoName);
    }
}



