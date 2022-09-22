package org.example;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CompleteTaskTests extends BaseSetup {

    @Test
    public void userCanCompleteTheTodo() {
        step.userAddsANewTodo();
        step.userCompletesTodo();
        step.userChecksIfTodoIsMarkedAsCompleted();
    }

    @Test
    public void completedTaskIsFilteredOutOnActiveFilter() {
        step.userAddsANewTodo();
        step.userCompletesTodo();
        step.userChecksIfCompletedTaskIsNotOnActiveTab();
    }

    @Test
    public void completedTaskInOnCompletedFilter() {
        step.userAddsANewTodo();
        step.userCompletesTodo();
        step.userChecksIfCompletedTaskIsOnCompletedTab();
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
