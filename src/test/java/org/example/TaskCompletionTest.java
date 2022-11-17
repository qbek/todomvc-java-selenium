package org.example;

import org.junit.jupiter.api.Test;

public class TaskCompletionTest extends BaseSetup {

    @Test
    public void userCanCompleteATask() {
        String taskName = "Zadanie do zakończenia";
        steps.userCreatesNewTask(taskName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsMarkedAsCompleted();
    }

    @Test
    public void userCannotSeeCompletedTaskOnActiveTab() {
        String taskName = "Zadanie do zakończenia";
        steps.userCreatesNewTask(taskName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskInNOTOnActiveTab(taskName);
    }

    @Test
    public void userSeesCompletedTaskOnCompletedTab() {
        String taskName = "Zadanie do zakończenia";
        steps.userCreatesNewTask(taskName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsOnCompletedTab(taskName);
    }



}
