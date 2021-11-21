package org.example;

import org.junit.Test;

public class CompleteTodoTest extends Base {

    @Test
    public void user_can_complete_the_todo() throws InterruptedException {
        String todoName = "Zadanie do zakończenia";
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTheTodo();
        steps.userChecksIfTodoIsMarkedAsCompleted();
    }

    @Test
    public void user_can_filter_active_todos() throws InterruptedException {
        String todoName = "Zadanie do zakończenia";
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTheTodo();
        steps.userChecksIfCompletedTodoIsNOTonActiveList(todoName);
    }

    @Test
    public void user_can_filter_completed_todos() throws InterruptedException {
        String todoName = "Zadanie do zakończenia";
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTheTodo();
        steps.userChecksIfCompletedTodoIsOnCompletedList(todoName);
    }
}
