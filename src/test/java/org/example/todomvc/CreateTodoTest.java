package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class CreateTodoTest extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = testData.getTodoName();
        given.userHasTodoMvcAppOpened();
        when.userCreatesANewTodo(todoName);
        then.userCheckTodoIsOnTodosList(todoName);
    }

    @Test
    public void userCanCreateAFewTodos() {
        var todos = testData.getFewTodos();
        given.userHasTodoMvcAppOpened();
        when.userCreatesAFewTodos(todos);
        then.userChecksAllTodosListed(todos);
    }

    public void userWaitsForTheONE() {
        given.userHasTodoMvcAppOpened();
        when.userCreatesANewTodo("The ONE");
        then.awaitlityWaitsForTheONE();
    }
}
