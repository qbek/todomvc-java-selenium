package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompletionTodoTests extends BaseSetup {

    @BeforeEach
    public void setup() {
        given.userIsOnTodoMVCapp();
    }

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Complete me";
        given.userHasTodo(todoName);
        when.userCompletesTodo();
        then.userChecksIfTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = "Complete me";
        given.userHasTodo(todoName);
        when.userCompletesTodo();
        then.userChecksIfCompletedTodoNotOnActiveTab(todoName);
    }

    @Test
    public void userCanFilterCompletedTodos() {
        var todoName = "Complete me";
        given.userHasTodo(todoName);
        when.userCompletesTodo();
        then.userChecksIfCompletedTodoOnCompletedTab(todoName);
    }

}
