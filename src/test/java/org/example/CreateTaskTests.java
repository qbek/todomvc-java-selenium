package org.example;

import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateTaskTests extends BaseSetup {

    @Test
    public void userCanAddTodo() {
        var todoName = "To jest moje lepsze zadanie";
        step.userAddsANewTodo(todoName);
        step.userChecksIfTodoIsCreated(todoName);
    }


}
