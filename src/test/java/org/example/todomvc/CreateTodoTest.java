package org.example.todomvc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CreateTodoTest extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = "Moje pierwsze Todo ze szkolenia";
        given.userHasTodoMvcAppOpened();
        when.userCreatesANewTodo(todoName);
        then.userCheckTodoIsOnTodosList(todoName);
    }

    @Test
    public void userCanCreateAFewTodos() {
        var todos = Arrays.asList("zadanie 1", "zadanie 2", "zadanie 3", "po poprzednim tescie");
        given.userHasTodoMvcAppOpened();
        when.userCreatesAFewTodos(todos);
        then.userChecksAllTodosListed(todos);
    }
}
