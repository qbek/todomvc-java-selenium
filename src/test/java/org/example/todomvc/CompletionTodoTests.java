package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class CompletionTodoTests extends BaseSetup {

    @Test
    public void userCanCompleteTodo() {
        String todoName = "Todo to be completed";
        step.userOpensTodoMVCApp();
        step.userCreatesANewTodo(todoName);
        step.userCompleteTodo();
        validateStep.userChecksIfTodoIsMarkedAsCompleted();
    }
}
