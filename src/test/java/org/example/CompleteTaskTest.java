package org.example;

import org.junit.jupiter.api.Test;

public class CompleteTaskTest extends BaseSetup {

    @Test
    public void userCanCompleteTodo() throws InterruptedException {
        var todoName = dataGenerator.chuckNorris().fact();
        step.userCreatesANewTodo(todoName);
        step.userCompletesTodo();
        step.userChecksItTodoIsMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = dataGenerator.programmingLanguage().creator();
        step.userHasCompletedTodo(todoName);
        step.userChecksIfCompletedTodoIsNotOnActiveFilter(todoName);
    }

    @Test
    public void userCanFilterCompletedTodos() {
        var todoName = dataGenerator.backToTheFuture().quote();
        step.userHasCompletedTodo(todoName);
        step.userChecksIfCompletedTodoIsOnCompletedFilter(todoName);
    }

    @Test
    public void userCompletesTheOne() throws InterruptedException {
        var fewTodos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsFewTodos(fewTodos);
        step.userCreatesANewTodo("THE ONE");
        fewTodos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsFewTodos(fewTodos);
        step.userCompletesTheOne();
        Thread.sleep(1000);
    }

}
