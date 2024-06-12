package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class TodoCreationTests extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = "Moje lepsze zadanie 2";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(todoName);
        steps.userChecksIfTodoIsCreated(todoName);
    }
}
