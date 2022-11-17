package org.example;

import org.junit.jupiter.api.Test;

public class TaskCreationTest  extends BaseSetup {

    @Test
    public void userCanCreateATask() {
        steps.userCreatesNewTask();
        steps.userChecksIfTodoIsOnTheList();
    }

}
