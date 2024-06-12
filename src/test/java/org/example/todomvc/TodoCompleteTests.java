package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class TodoCompleteTests extends BaseTestSetup {

    @Test
    public void userCanCompleteTodo() {
        var todoName = "jakies inne zadaie";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTodo();
        steps.userChecksIfTodoMarkedAsCompleted();
        steps.userChecksIfCompltedTodoIsNotOnActiveList();
        steps.userChecksIfCompletedTodoIsOnCompletedList(todoName);
    }

}
