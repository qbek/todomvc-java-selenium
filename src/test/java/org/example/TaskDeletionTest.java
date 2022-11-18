package org.example;

import org.junit.jupiter.api.Test;

public class TaskDeletionTest extends BaseSetup {

    @Test
    public void userCanDeleteExistingTask() {
        given.hasCreatedTodo();
        when.userDeletesTodo();
        then.userChecksIfTodoIsNotOnTheList();
    }

    @Test
    public void userCanDeleteTheOne() {
        when.userCreatesFewTodos();
        when.userCreateTheOne();
        when.userCreatesFewTodos();
        when.userDeletesTheOne();
    }
}
