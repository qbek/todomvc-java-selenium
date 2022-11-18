package org.example;

import org.junit.jupiter.api.Test;

public class TaskCompletionTest extends BaseSetup {

    @Test
    public void userCanCompleteATask() {
        given.userHasCreatedTodo();
        when.userCompletesTheTask();
        then.userChecksIfTaskIsMarkedAsCompleted();
    }

    @Test
    public void userCannotSeeCompletedTaskOnActiveTab() {
        given.userHasCompletedTodo();
        when.userSwitchesToActiveTab();
        then.userChecksIfTaskIsNOTDisplayed();
    }

    @Test
    public void userSeesCompletedTaskOnCompletedTab() {
        given.userHasCompletedTodo();
        when.userSwitchesToCompletedTab();
        then.userChecksIfTodoIsOnTheList();
    }
}
