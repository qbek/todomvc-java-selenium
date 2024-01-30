package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class TaskCompletionTests extends BaseTestSetup {

    @Test
    public void userCanCompleteTask () {
        String todoName = "Moje zadanie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTask(todoName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTasks() {
        String todoName = "Moje zadanie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTask(todoName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskInNOTOnActiveTab();
    }

    @Test
    public void usercanFilterCompletedTasks () {
        String todoName = "Moje zadanie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTask(todoName);
        steps.userCompletesTheTask();
        steps.userChecksIfTaskIsOnCompletedTab(todoName);
    }
}
