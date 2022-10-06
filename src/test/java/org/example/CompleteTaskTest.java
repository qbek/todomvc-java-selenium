package org.example;

import org.junit.jupiter.api.Test;

public class CompleteTaskTest extends BaseSetup {

    @Test
    public void userCanCompleteTodo() throws InterruptedException {
        step.userCreatesANewTodo();
        step.userCompletesTodo();
        step.userChecksItTodoIsMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        step.userHasCompletedTodo();
        step.userChecksIfCompletedTodoIsNotOnActiveFilter();
    }

    @Test
    public void userCanFilterCompletedTodos() {
        step.userHasCompletedTodo();
        step.userChecksIfCompletedTodoIsOnCompletedFilter();
    }

    @Test
    public void userCompletesTheOne() throws InterruptedException {
        var fewTodos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsFewTodos(fewTodos);
        step.userCreatesANewTodo("THE ONE");
        fewTodos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsFewTodos(fewTodos);
        step.userCompletesTheOne();
    }

}
