package org.example.todomvc;

import org.example.todomvc.data.TestData;
import org.junit.jupiter.api.Test;

import static org.example.todomvc.data.TestData.getTodoName;

public class CompletionTodoTests extends BaseSetup {

    @Test
    public void userCanCompleteTodo() {
        String todoName = getTodoName();
        step.userOpensTodoMVCApp();
        step.userCreatesANewTodo(todoName);
        step.userCompleteTodo();
        validateStep.userChecksIfTodoIsMarkedAsCompleted();
    }
}
