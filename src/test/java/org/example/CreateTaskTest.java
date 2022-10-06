package org.example;

import org.junit.jupiter.api.Test;

public class CreateTaskTest extends BaseSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = dataGenerator.witcher().monster();
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoWasCreated(todoName);
    }
}

