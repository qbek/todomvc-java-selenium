package org.example;

import org.junit.jupiter.api.Test;
import static org.example.data.TestDataManager.setupTodosNamesTestData;


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
