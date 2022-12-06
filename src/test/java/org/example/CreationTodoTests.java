package org.example;

import org.junit.jupiter.api.Test;


public class CreationTodoTests extends BaseSetup {

    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie";
        given.userIsOnTodoMVCapp();
        when.userCreatesNewTodo(todoName);
        then.userChecksIfTodoWasCreated(todoName);
    }

}
