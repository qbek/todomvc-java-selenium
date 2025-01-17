package org.example.todomvc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CreateTodoTests extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var name = "To jest moje zadanie";
        userActions.userOpensTodoMVCapp();
        userActions.userCreatesANewTodo(name);
        userActions.userChecksIfTodoIsCreated();
    }

    @Test
    public void userCanAddFewTodos() {
        var names = Arrays.asList("Todo 11", "Todo 33");
        var expected = Arrays.asList("Todo 11", "Todo 33");
        userActions.userOpensTodoMVCapp();
        userActions.userCreatesAFewTodos(names);
        userActions.userChecksIfAllTodosAreCreated(expected);
    }

    @Test
    public void test() {
        var env = System.getProperty("env", "nie ma");
        System.out.println(env);
    }

}

