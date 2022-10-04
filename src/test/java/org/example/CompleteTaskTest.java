package org.example;

import org.junit.jupiter.api.Test;

public class CompleteTaskTest extends BaseSetup {

    @Test
    public void userCanCompleteTodo() {
        var todoName = "To jest zadanie do zamknięcia";
        step.userCreatesANewTodo(todoName);
        step.userCompletesTodo();
        step.userChecksItTodoIsMarkedAsCompleted();
        step.userChecksIfCompletedTodoIsNotOnActiveFilter(todoName);
        step.userChecksIfCompletedTodoIsOnCompletedFilter(todoName);
    }

}
