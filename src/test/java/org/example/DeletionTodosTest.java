package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeletionTodosTest extends BaseSetup {

    @BeforeEach
    public void setup() {
        given.userIsOnTodoMVCapp();
    }

    @Test
    public void userCanDeleteATodo() {
        var todoName = "Delete me!";
        given.userHasTodo(todoName);
        when.userDeletesTodo();
        then.userChecksIfDeletedTodoIsNotOnTheList(todoName);
    }

    @Test
    public void userCanDeleteTheONE() {
        when.userCreatesFewTodos();
        when.userCreatesNewTodo("THE ONE");
        when.userCreatesFewTodos();
        when.userDeletesTodo("THE ONE");
    }
}
