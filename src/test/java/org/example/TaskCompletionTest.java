package org.example;

import org.junit.jupiter.api.Test;

public class TaskCompletionTest extends BaseSetup {

    @Test
    public void userCanCompleteATask() {
        given.hasCreatedTodo();
        when.userCompletesTheTask();
        then.userChecksIfTaskIsMarkedAsCompleted();
    }

    @Test
    public void userCannotSeeCompletedTaskOnActiveTab() {
        given.userHasCompletedTask();
        when.userSwitchesToActiveTab();
        then.userChecksIfTaskIsNOTDisplayed();
    }

    @Test
    public void userSeesCompletedTaskOnCompletedTab() {
        given.userHasCompletedTask();
        when.userSwitchesToCompletedTab();
        then.userChecksIfTodoIsOnTheList();
    }
}
