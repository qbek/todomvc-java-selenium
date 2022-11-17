package org.example;

import org.junit.jupiter.api.Test;

public class TaskCompletionTest extends BaseSetup {

    @Test
    public void userCanCompleteATask() {
        steps.userCreatesNewTask();
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsMarkedAsCompleted();
    }

    @Test
    public void userCannotSeeCompletedTaskOnActiveTab() {
        steps.userCreatesNewTask();
        steps.userCompletesTheTask();
        steps.userChecksIfTaskInNOTOnActiveTab();
    }

    @Test
    public void userSeesCompletedTaskOnCompletedTab() {
        steps.userCreatesNewTask();
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsOnCompletedTab();
    }
}
