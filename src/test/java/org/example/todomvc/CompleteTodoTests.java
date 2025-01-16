package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompleteTodoTests extends BaseTestSetup {

    @Test
    public void userCanCompleteATodo() {
        var name = "Zadanie do skonczenia";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(name);
        steps.userCompletesTodo();
        steps.userChecksIfTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var name = "Zadanie XYZ";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(name);
        steps.userCompletesTodo();
        steps.userChecksIfCompletedTodoIsNotOnActiveTab();
    }

    @Test
    public void  userCanFilterCompletedTodos() {
        var name = "Zadanie 123";
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTodo(name);
        steps.userCompletesTodo();
        steps.userChecksIfCompletedTodoIsOnCompletedTab();
    }
}
