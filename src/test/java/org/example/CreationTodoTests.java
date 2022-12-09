package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.example.data.TestDataManager.setupTodosNamesTestData;

@Execution(ExecutionMode.SAME_THREAD)
public class CreationTodoTests extends BaseSetup {

    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie";
        given.userIsOnTodoMVCapp();
        when.userCreatesNewTodo(todoName);
        then.userChecksIfTodoWasCreated(todoName);
    }

    @Test
    public void userCanCreateFewTodos() {
        given.userIsOnTodoMVCapp();
        when.userCreatesFewTodos();
        then.userCheckIfAllTodosAreCreated();
    }
}
