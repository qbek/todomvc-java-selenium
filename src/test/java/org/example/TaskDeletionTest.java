package org.example;

import org.junit.jupiter.api.Test;

public class TaskDeletionTest extends BaseSetup {

    @Test
    public void userCanDeleteExistingTask() {
        steps.userCreatesNewTask();
        steps.userDeletesTask();
        steps.userChecksIfTodoIsNotOnTheList();
    }

    @Test
    public void userCanDeleteTheOne() {
        steps.userCreatesFewTodos();
        steps.userCreateTheOne();
        steps.userCreatesFewTodos();
        steps.userDeletesTheOne();
    }
}
