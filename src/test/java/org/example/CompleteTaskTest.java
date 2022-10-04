package org.example;

import org.junit.jupiter.api.Test;

public class CompleteTaskTest extends BaseSetup {

    @Test
    public void userCanCompleteTodo() {
        var todoName = "To jest zadanie do zamknięcia";
        step.userCreatesANewTodo(todoName);
        step.userCompletesTodo();
        step.userChecksItTodoIsMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = "To jest zadanie do zamknięcia";
        step.userCreatesANewTodo(todoName);
        step.userCompletesTodo();
        step.userChecksIfCompletedTodoIsNotOnActiveFilter(todoName);
    }

    @Test
    public void userCanFilterCompletedTodos() {
        var todoName = "To jest zadanie do zamknięcia";
        step.userCreatesANewTodo(todoName);
        step.userCompletesTodo();
        step.userChecksIfCompletedTodoIsOnCompletedFilter(todoName);
    }

}
