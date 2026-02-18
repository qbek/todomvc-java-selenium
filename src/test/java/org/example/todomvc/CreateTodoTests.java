package org.example.todomvc;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class CreateTodoTests extends BaseTestSetup {

    @Test
    public void userCanCreateANewTodo() {
        var todoName = testData.generateTodoName();
        steps.userCreatesANewTodo(todoName);
        steps.userChecksIfTodoIsListed(todoName);
    }

    @Test
    public void userCanCreateAFewTodos() {
        var todosNames = testData.generateFewTodoNames();
        steps.userCreatesFewTodos(todosNames);
        steps.userChecksAllTodos(todosNames);
    }

    @Test
    public void userWaitsForTheONE() {
        steps.userWaitsForTheONE();
    }
}
