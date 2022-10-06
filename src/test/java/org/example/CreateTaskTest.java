package org.example;

import org.junit.jupiter.api.Test;

public class CreateTaskTest extends BaseSetup {

    @Test
    public void userCanCreateATodo() {
        step.userCreatesANewTodo();
        step.userChecksIfTodoWasCreated();
    }
}

