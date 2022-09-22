package org.example;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CompleteTaskTests extends BaseSetup {

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = dataGenerator.chuckNorris().fact();
        step.userAddsANewTodo(todoName);
        step.userCompletesTodo(todoName);
        step.userChecksIfTodoIsMarkedAsCompleted(todoName);
    }

    @Test
    public void completedTaskIsFilteredOutOnActiveFilter() {
        var todoName = dataGenerator.witcher().character();
        step.userAddsANewTodo(todoName);
        step.userCompletesTodo(todoName);
        step.userChecksIfCompletedTaskIsNotOnActiveTab(todoName);
    }

    @Test
    public void completedTaskInOnCompletedFilter() {
        var todoName = dataGenerator.business().creditCardType();
        step.userAddsANewTodo(todoName);
        step.userCompletesTodo(todoName);
        step.userChecksIfCompletedTaskIsOnCompletedTab(todoName);
    }

    @Test
    public void userCanCompleteTHE_ONE() throws InterruptedException {
        List<String> todos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsTodos(todos);
        step.userAddsANewTodo("THE ONE");
        todos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsTodos(todos);
        step.userCompletesTodo("THE ONE");
        step.userChecksIfTodoIsMarkedAsCompleted("THE ONE");
        Thread.sleep(2000);
    }
}
