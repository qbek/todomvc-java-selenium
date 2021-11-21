package org.example;

import org.junit.Test;

import java.io.IOException;

public class CompleteTodoTest extends Base {

    @Test
    public void user_can_complete_the_todo() {
        String todoName = data.getTodoName();
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTheTodo();
        steps.userChecksIfTodoIsMarkedAsCompleted();
    }

    @Test
    public void user_can_filter_active_todos() {
        String todoName = data.getTodoName();
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTheTodo();
        steps.userChecksIfCompletedTodoIsNOTonActiveList(todoName);
    }

    @Test
    public void user_can_filter_completed_todos() {
        String todoName = data.getTodoName();
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTheTodo();
        steps.userChecksIfCompletedTodoIsOnCompletedList(todoName);
    }
}
