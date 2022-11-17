package org.example;

import org.junit.jupiter.api.Test;

public class TaskCreationTest  extends BaseSetup {

    @Test
    public void userCanCreateATask() {
        String taskName = "To jest zadanie";
        steps.userCreatesNewTask(taskName);
        steps.userChecksIfTodoIsOnTheList(taskName);
    }

}
