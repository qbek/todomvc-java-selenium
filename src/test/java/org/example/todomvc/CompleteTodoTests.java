package org.example.todomvc;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CompleteTodoTests extends BaseTestSetup {

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = testData.generateTodoName();
        preconditions.userHasTodoCreated(todoName);
        steps.userCompletesTodo();
        steps.userChecksIfTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = testData.generateTodoName();
        preconditions.userHasCompletedTodo(todoName);
        steps.userGoesToActiveTodos();
        steps.userChecksIfListIsEmpty();
    }

    @Test
    public void userCanFilterCompltedTodos() {
        var todoName = testData.generateTodoName();
        preconditions.userHasCompletedTodo(todoName);
        steps.userGoesToCompletedTodos();
        steps.userChecksIfTodoIsListed(todoName);
    }


}
