package org.example.todomvc;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class CreateTodoTests extends BaseTestSetup {

    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie żółć";
        steps.userCreatesANewTodo(todoName);
        steps.userChecksIfTodoIsListed(todoName);
    }

    @Test
    public void userCanCreateAFewTodos() {
        var todosNames = Arrays.asList("task 1", "task 2", "task 3", "task 4");
        steps.userCreatesFewTodos(todosNames);
        steps.userChecksAllTodos(todosNames);
    }
}
