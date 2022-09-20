package org.example;

import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateTaskTests {

    UserSteps step = new UserSteps();

    @BeforeEach
    public void setup() {
        step.userOpensTodoMVCApp();
    }

    @AfterEach
    public void cleanUp() {
        step.userClosesTodoMVCApp();
    }

    @Test
    public void userCanAddTodo() {
        var todoName = "To jest moje lepsze zadanie";
        step.userAddsANewTodo(todoName);
        step.userChecksIfTodoIsCreated(todoName);
    }

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = "Ten task jest zakończony";
        step.userAddsANewTodo(todoName);
        step.userCompletesTodo();
        step.userChecksIfTodoIsMarkedAsCompleted();
        step.userChecksIfCompletedTaskIsNotOnActiveTab(todoName);
        step.userChecksIfCompletedTaskIsNotOnCompletedTab(todoName);
    }
}
