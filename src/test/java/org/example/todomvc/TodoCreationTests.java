package org.example.todomvc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TodoCreationTests extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = testData.getTaskName();
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(todoName);
        steps.userChecksIfTodoIsCreated(todoName);
    }

    @Test
    public void userCanCreateAFewTodos() {
//        var todos = testData.getFewTodos();

        var createdTodos = Arrays.asList("t1", "t2", "t3", "t4", "t5");
        var expectedTodos = Arrays.asList("t4", "t3", "t6");

        steps.userOpensTodoMVCapp();
        steps.userCreatesAFewTodos(createdTodos);
        steps.userChecksIfAllTodosAreCreated(expectedTodos);
    }

}

