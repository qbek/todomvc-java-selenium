package org.example;

import org.junit.jupiter.api.Test;

public class CreateTaskTest extends BaseSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = "To jest moje fajniejsze zadanie";
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoWasCreated(todoName);
    }
}

